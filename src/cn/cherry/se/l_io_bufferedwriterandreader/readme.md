###BufferedWriter和BufferedReader的定义
- BufferedWriter
  - “缓存字符输出流"，内置一个缓存字符数组，每次写入前都会先检查缓存数组，是否已满，满了把缓存数组写入。否则将内容放到缓存数组中去。
  - newLine()方法 “换行方法”
- BufferedReader
  - “缓存字符输入流”，内置一个缓存字符数组，每次读取都会先去缓冲数组中读取，如果已读完，则会在家流中的下一块数据。打个比方：就是一块一块的读，不是一个个读，提高了效率。
  - readLine()方法 “读取行的方法”
###原理分析
- BufferedWriter原理分析
  - 构造方法
  ```
  public BufferedWriter(Writer out) {
          this(out, defaultCharBufferSize);
  }
  // 真正构造的地方
  public BufferedWriter(Writer out, int sz) {
      // 构造输出流
      super(out);
      if (sz <= 0)
          throw new IllegalArgumentException("Buffer size <= 0");
      this.out = out;
      cb = new char[sz];
      // 缓存数组大小
      nChars = sz;
      // 下一个字符的位置索引
      nextChar = 0
      // 根据操作系统的不同得到换行符，win“\r\n” unix"\n"
      lineSeparator = java.security.AccessController.doPrivileged(
          new sun.security.action.GetPropertyAction("line.separator"));
  }
  ```
  - write(String s, int off, int len)
  ```
  public void write(String s, int off, int len) throws IOException {
      synchronized (lock) {
          ensureOpen()
          int b = off, t = off + len;
          // 判断是否要内容需要写入
          while (b < t) {
              // nChars - nextChar 表示当前缓存字节中剩下空间
              // t - b 表示此次要写入的所占空间个数
              // d 表示写入当前缓冲数组的合理大小，例如：此次要写入10个字符，但是缓冲区只剩下8个空间，他会10个中8个写入到缓存数组中去，
              int d = min(nChars - nextChar, t - b);
              // copy内容到缓存数组去
              s.getChars(b, b + d, cb, nextChar);
              b += d;
              nextChar += d;
              if (nextChar >= nChars)
                  // 刷新缓冲区
                  flushBuffer();
          }
      }
  }
  
  void flushBuffer() throws IOException {
      synchronized (lock) {
          ensureOpen();
          if (nextChar == 0)
              return;
          // 写操作
          out.write(cb, 0, nextChar);
          nextChar = 0;
      }
  }
  ```
  - newLine()
  ```
      public void newLine() throws IOException {
          // 换行符在初始化流，已经自动从根据系统获取
          write(lineSeparator);
      }
  ```
  - write(char cbuf[], int off, int len)
  ```
      public void write(char cbuf[], int off, int len) throws IOException {
          synchronized (lock) {
              ensureOpen();
              // 对写入的字符数组进行校验，排除一些简单异常
              if ((off < 0) || (off > cbuf.length) || (len < 0) ||
                  ((off + len) > cbuf.length) || ((off + len) < 0)) {
                  throw new IndexOutOfBoundsException();
              } else if (len == 0) {
                  return;
              }
              
              // 如果要写入的字符数组大小大于缓冲区大小，则先刷新缓存区，然后接
              // 需写入的字符数组直接写入
              if (len >= nChars) {
                  /* If the request length exceeds the size of the output buffer,
                     flush the buffer and then write the data directly.  In this
                     way buffered streams will cascade harmlessly. */
                  flushBuffer();
                  out.write(cbuf, off, len);
                  return;
              }
  
              // 要写入字符数组的长度没有缓冲缓冲区大小大的情况：
              int b = off, t = off + len;
              while (b < t) {
                  int d = min(nChars - nextChar, t - b);
                  System.arraycopy(cbuf, b, cb, nextChar, d);
                  b += d;
                  nextChar += d;
                  if (nextChar >= nChars)
                      flushBuffer();
              }
          }
      }
  ```
- BufferedReader原理分析
  - 构造方法
  ```
      // 构造入口1
      public BufferedReader(Reader in) {
          this(in, defaultCharBufferSize);
      }
      
      // 最底层的构造器
      public BufferedReader(Reader in, int sz) {
          super(in);
          if (sz <= 0)
              throw new IllegalArgumentException("Buffer size <= 0");
          this.in = in;
          cb = new char[sz];
          nextChar = nChars = 0;
      }
  ```
  - read()
  ```
      public int read() throws IOException {
          synchronized (lock) {
              ensureOpen();
              for (;;) {
                  // 下一个读取的字符索引大于等于缓冲区总共的数，表示已经读完此缓冲区内容，需重新刷新下
                  if (nextChar >= nChars) {
                      fill();
                      // 刷新后如果还是大于等于，则表示已经读完，返回-1
                      if (nextChar >= nChars)
                          return -1;
                  }
                  // 如果有跳过的字节，则执行此
                  if (skipLF) {
                      skipLF = false;
                      if (cb[nextChar] == '\n') {
                          nextChar++;
                          continue;
                      }
                  }
                  return cb[nextChar++];
              }
          }
      }
      
      // 填充缓冲区
      private void fill() throws IOException {
          int dst;
          if (markedChar <= UNMARKED) {
              /* No mark */
              dst = 0;
          } else {
              /* Marked */
              int delta = nextChar - markedChar;
              if (delta >= readAheadLimit) {
                  /* Gone past read-ahead limit: Invalidate mark */
                  markedChar = INVALIDATED;
                  readAheadLimit = 0;
                  dst = 0;
              } else {
                  if (readAheadLimit <= cb.length) {
                      /* Shuffle in the current buffer */
                      System.arraycopy(cb, markedChar, cb, 0, delta);
                      markedChar = 0;
                      dst = delta;
                  } else {
                      /* Reallocate buffer to accommodate read-ahead limit */
                      char ncb[] = new char[readAheadLimit];
                      System.arraycopy(cb, markedChar, ncb, 0, delta);
                      cb = ncb;
                      markedChar = 0;
                      dst = delta;
                  }
                  nextChar = nChars = delta;
              }
          }
  
          int n;
          // 将流中的数据中一块读入到缓冲区中
          do {
              n = in.read(cb, dst, cb.length - dst);
          } while (n == 0);
          if (n > 0) {
              nChars = dst + n;
              nextChar = dst;
          }
      }
  ```
  - read(char cbuf[], int off, int len)
  ```
      public int read(char cbuf[], int off, int len) throws IOException {
          synchronized (lock) {
              // 排除一些简单异常和错误
              ensureOpen();
              if ((off < 0) || (off > cbuf.length) || (len < 0) ||
                  ((off + len) > cbuf.length) || ((off + len) < 0)) {
                  throw new IndexOutOfBoundsException();
              } else if (len == 0) {
                  return 0;
              }
              
              // 真正读取的方法，返回读取的字符数
              int n = read1(cbuf, off, len);
              if (n <= 0) return n;
              
              // 针对最后一次没有读慢的情况
              while ((n < len) && in.ready()) {
                  int n1 = read1(cbuf, off + n, len - n);
                  if (n1 <= 0) break;
                  n += n1;
              }
              return n;
          }
      }
      
      // 真正读取的方法
      private int read1(char[] cbuf, int off, int len) throws IOException {
          // 排除一些简单的错误
          if (nextChar >= nChars) {
              /* If the requested length is at least as large as the buffer, and
                 if there is no mark/reset activity, and if line feeds are not
                 being skipped, do not bother to copy the characters into the
                 local buffer.  In this way buffered streams will cascade
                 harmlessly. */
              if (len >= cb.length && markedChar <= UNMARKED && !skipLF) {
                  return in.read(cbuf, off, len);
              }
              //  刷新缓冲区
              fill();
          }
          if (nextChar >= nChars) return -1;
          if (skipLF) {
              skipLF = false;
              if (cb[nextChar] == '\n') {
                  nextChar++;
                  if (nextChar >= nChars)
                      fill();
                  if (nextChar >= nChars)
                      return -1;
              }
          }
          int n = Math.min(len, nChars - nextChar);
          // 读取操作
          System.arraycopy(cb, nextChar, cbuf, off, n);
          nextChar += n;
          return n;
      }
  ```
  - readLine()和readLine(boolean ignoreLF)
  ```readLine(boolean ignoreLF)
      String readLine(boolean ignoreLF) throws IOException {
          StringBuffer s = null;
          int startChar;
  
          synchronized (lock) {
              ensureOpen();
              boolean omitLF = ignoreLF || skipLF;
          
          // 使用了标记循环
          bufferLoop:
              for (;;) {
  
                  if (nextChar >= nChars)
                      fill();
                  if (nextChar >= nChars) { /* EOF */
                      if (s != null && s.length() > 0)
                          return s.toString();
                      else
                          return null;
                  }
                  boolean eol = false;
                  char c = 0;
                  int i;
  
                  /* Skip a leftover '\n', if necessary */
                  if (omitLF && (cb[nextChar] == '\n'))
                      nextChar++;
                  skipLF = false;
                  omitLF = false;
                
              // 行读取
              charLoop:
                  for (i = nextChar; i < nChars; i++) {
                      c = cb[i];
                      // 读到换行符停止，并记录字符数
                      if ((c == '\n') || (c == '\r')) {
                          eol = true;
                          break charLoop;
                      }
                  }
  
                  startChar = nextChar;
                  nextChar = i;
  
                  // 把读到的字符数组转换为字符串返回
                  if (eol) {
                      String str;
                      if (s == null) {
                          str = new String(cb, startChar, i - startChar);
                      } else {
                          s.append(cb, startChar, i - startChar);
                          str = s.toString();
                      }
                      nextChar++;
                      if (c == '\r') {
                          skipLF = true;
                      }
                      return str;
                  }
  
                  if (s == null)
                      s = new StringBuffer(defaultExpectedLineLength);
                  s.append(cb, startChar, i - startChar);
              }
          }
      }
  ```
###总结
- BufferedReader、BufferedWriter、本质就是为底层字符输入输出流添加缓冲功能、先将底层流中的要读取或者要写入的数据先以一次读取一组的形式来讲数据读取或者写入到buffer中、再对buffer进行操作、这样不但效率、还能节省资源。
- 注意理解标记循环