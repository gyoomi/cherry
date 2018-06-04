###BufferedInputStream和BufferedOutputStream介绍
- BufferedInputStream
  - 定义  
  是缓冲输入流，它继承于FilterInputStream。
  - 作用  
  为需要包装的输入流提供了缓冲功能以及如mark()等其他功能。
  - 实现  
  实质是通过内部一个缓存数组来实现“缓冲区”的功能。
- BufferedOutputStream
  - 定义  
  缓存字节输出流，同样也继承自FilterInputStream。
  - 作用
  同上。
  - 实现
  实质是通过内部一个缓存数组来实现“缓冲区”的功能。
###原理分析
- BufferedInputStream主要原理分析
  - read()
  ```
      public synchronized int read() throws IOException {
          // 如果当前已读取的字节数已大于缓存区的总字节大小，则需要需要刷新缓存区，进行新的缓存
          if (pos >= count) {
              // 执行缓存的操作
              fill();
              // 读完返回-1
              if (pos >= count)
                  return -1;
          }
          // 返回文件指针指向的字节
          return getBufIfOpen()[pos++] & 0xff;
      }
      
       private void fill() throws IOException {
              byte[] buffer = getBufIfOpen();
              if (markpos < 0)
                  pos = 0;            /* no mark: throw away the buffer */
              else if (pos >= buffer.length)  /* no room left in buffer */
                  if (markpos > 0) {  /* can throw away early part of the buffer */
                      int sz = pos - markpos;
                      System.arraycopy(buffer, markpos, buffer, 0, sz);
                      pos = sz;
                      markpos = 0;
                  } else if (buffer.length >= marklimit) {
                      markpos = -1;   /* buffer got too big, invalidate mark */
                      pos = 0;        /* drop buffer contents */
                  } else if (buffer.length >= MAX_BUFFER_SIZE) {
                      throw new OutOfMemoryError("Required array size too large");
                  } else {            /* grow buffer */
                      int nsz = (pos <= MAX_BUFFER_SIZE - pos) ?
                              pos * 2 : MAX_BUFFER_SIZE;
                      if (nsz > marklimit)
                          nsz = marklimit;
                      byte nbuf[] = new byte[nsz];
                      System.arraycopy(buffer, 0, nbuf, 0, pos);
                      if (!bufUpdater.compareAndSet(this, buffer, nbuf)) {
                          // Can't replace buf if there was an async close.
                          // Note: This would need to be changed if fill()
                          // is ever made accessible to multiple threads.
                          // But for now, the only way CAS can fail is via close.
                          // assert buf == null;
                          throw new IOException("Stream closed");
                      }
                      buffer = nbuf;
                  }
              count = pos;
              // 将数组读取缓存区中
              int n = getInIfOpen().read(buffer, pos, buffer.length - pos);
              if (n > 0)
                  count = n + pos;
          }
  ```
  - read(byte b[], int off, int len)
  ```
      public synchronized int read(byte b[], int off, int len)
          throws IOException
      {
          // 检测流是否关闭
          getBufIfOpen(); // Check for closed stream
          
          // 如果len为0，不进行读取，直接返回0
          if ((off | len | (off + len) | (b.length - (off + len))) < 0) {
              throw new IndexOutOfBoundsException();
          } else if (len == 0) {
              return 0;
          }
          
          // 设定返回此次读取的字节数，并从此开始计数
          int n = 0;
          for (;;) {
              // 真正将缓存区的数据读到传入的数组中去
              int nread = read1(b, off + n, len - n);
              
              // 返回此次读取的字节数
              if (nread <= 0)
                  return (n == 0) ? nread : n;
              n += nread;
              if (n >= len)
                  return n;
              // if not closed but no bytes available, return
              InputStream input = in;
              if (input != null && input.available() <= 0)
                  return n;
          }
      }
      
      /* 真正将缓存区的数组读到给定数组中的方法 */
      private int read1(byte[] b, int off, int len) throws IOException {
          // 当前缓存区中字节总数  - 上次读到的字节数组的位置下标 = 本次读取可用的字节数
          int avail = count - pos;
          if (avail <= 0) {
              // 如果缓存中全部已读取过，则重新重新加载缓存区数据
              /* If the requested length is at least as large as the buffer, and
                 if there is no mark/reset activity, do not bother to copy the
                 bytes into the local buffer.  In this way buffered streams will
                 cascade harmlessly. */
              if (len >= getBufIfOpen().length && markpos < 0) {
                  return getInIfOpen().read(b, off, len);
              }
              fill();
              avail = count - pos;
              // 如果加载不到数据，则表示文件已经读完，返回-1
              if (avail <= 0) return -1;
          }
          // 将缓存区的数据一部分复制到给定的数组中去
          int cnt = (avail < len) ? avail : len;
          System.arraycopy(getBufIfOpen(), pos, b, off, cnt);
          pos += cnt;
          return cnt;
      }
  ```
- BufferedOutputStream主要原理分析
  - write(int b)
  ```
     public synchronized void write(int b) throws IOException {
          // 写入前，先判断缓存区是否已满，如果已满，则刷新缓存区
          // 否则把数据写入缓存区中去
          if (count >= buf.length) {
              flushBuffer();
          }
          buf[count++] = (byte)b;
     }
      
     /** Flush the internal buffer */
     private void flushBuffer() throws IOException {
         if (count > 0) {
             out.write(buf, 0, count);
             count = 0;
         }
     }
  ```
  - write(byte b[], int off, int len)
  ```
      public synchronized void write(byte b[], int off, int len) throws IOException {
          // 如果给定的数组大于缓存区，则不使用缓存数组，直接写入
          if (len >= buf.length) {
              /* If the request length exceeds the size of the output buffer,
                 flush the output buffer and then write the data directly.
                 In this way buffered streams will cascade harmlessly. */
              flushBuffer();
              out.write(b, off, len);
              return;
          }
          // 如果写入的长度大于缓存余下空闲空间，则先刷新缓存区，然后在把内容放入缓存区
          if (len > buf.length - count) {
              flushBuffer();
          }
          System.arraycopy(b, off, buf, count, len);
          count += len;
      }
  ```
###总结
- 优点
  - 减少了IO频繁读取开关，大大提高了效率
- 场景
  - 提高读取效率场景下使用，尽量为比较底层的流都以此流进行包装以提高效率和资源。
- 注意
  - BufferedOutputStream中的write方法每次都会先执行缓存区判断
  - 数据缓存区中count记录着上次读或写的位置
  - BufferedInputStream、BufferedOutputStream、本质就是为底层字节输入输出流添加缓冲功能