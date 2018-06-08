###BufferedWriter和BufferedReader的定义
- BufferedWriter
  - “缓存字符输出流"，内置一个缓存字符数组，每次写入前都会先检查缓存数组，是否已满，满了把缓存数组写入。否则将内容放到缓存数组中去。
  - newLine()方法 “换行方法”
- BufferedReader
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
                  flushBuffer();
          }
      }
  }
  ```
- BufferedReader原理分析
###总结