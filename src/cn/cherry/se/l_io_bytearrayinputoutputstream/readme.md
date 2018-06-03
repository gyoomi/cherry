###ByteArrayOutputStream和ByteArrayInputStream介绍
- 概念
  - ByteArrayOutputStream  
        "字节数组输出流"，内部有有一个缓存字节的数组作为缓存区，所有发送到输出流的数据保存在该字节数组缓冲区中。
        其中字节的数组的数据顺序和数量很重要。
  - ByteArrayInputStream  
        "字节数组输入流"，在内存中创建一个字节数组缓冲区，从输入流读取的数据保存在该字节数组缓冲区中。
###实现原理
- ByteArrayOutputStream原理分析
  - write(int b)
  ```
      public synchronized void write(int b) {
          // 确保缓存数组的长度，如果不够，则会进行增长
          ensureCapacity(count + 1);
          // 写入缓存数组中
          buf[count] = (byte) b;
          count += 1;
      }
      
      // 检测容量
      private void ensureCapacity(int minCapacity) {
          // overflow-conscious code
          // 如果要写入的内容大小大于缓存数组大小，则需要进行容量自增
          if (minCapacity - buf.length > 0)
              grow(minCapacity);
      }
      
      // 自动增长方法
      private void grow(int minCapacity) {
          // overflow-conscious code
          int oldCapacity = buf.length;
          int newCapacity = oldCapacity << 1;
          if (newCapacity - minCapacity < 0)
              newCapacity = minCapacity;
          if (newCapacity - MAX_ARRAY_SIZE > 0)
              newCapacity = hugeCapacity(minCapacity);
          // 将原数组内容复制到新数组中，长度是增长后的
          buf = Arrays.copyOf(buf, newCapacity);
      }
  ```
  - write(byte b[], int off, int len)
  ```
      public synchronized void write(byte b[], int off, int len) {
          if ((off < 0) || (off > b.length) || (len < 0) ||
              ((off + len) - b.length > 0)) {
              throw new IndexOutOfBoundsException();
          }
          ensureCapacity(count + len);
          // 将要写入的字节数组内容添加到缓存数组中
          System.arraycopy(b, off, buf, count, len);
          count += len;
      }
    ```
    - writeTo(OutputStream out)
    ```
        public synchronized void writeTo(OutputStream out) throws IOException {
            out.write(buf, 0, count);
        }
    ```
    - toString() 将缓存区内容转成字符串返回
    ```
        public synchronized String toString() {
            return new String(buf, 0, count);
        }
    ```
    - size() 返回内置缓存数组长度；即属性count
    - reset() 将内置缓存数组长度为0
- ByteArrayInputStream原理分析
  - 构造函数
  ```
    public ByteArrayInputStream(byte buf[], int offset, int length) {
        this.buf = buf;
        this.pos = offset;
        // 初始化buf的长度、取min的意义在于剔除不合理参数、避免出现异常
        this.count = Math.min(offset + length, buf.length);
        this.mark = offset;
    }
    ```
  - read() 读取源字节数组中的字节
  ```
        public synchronized int read() {
            // 如果读到末尾，返回-1
            return (pos < count) ? (buf[pos++] & 0xff) : -1;
        }
  ```
  - read(byte b[], int off, int len) 
  ```
   public synchronized int read(byte b[], int off, int len) {
          if (b == null) {
              throw new NullPointerException();
          } else if (off < 0 || len < 0 || len > b.length - off) {
              throw new IndexOutOfBoundsException();
          }
            
          // 如果缓存数组中没有内容，则返回-1
          if (pos >= count) {
              return -1;
          }
  
          // count总比可读的字节数大1
          int avail = count - pos;
          if (len > avail) {
              len = avail;
          }
          if (len <= 0) {
              return 0;
          }
          // 将buf下标为pos的之后的字节数组复制到b中下标从b开始长度为len的数组中
          System.arraycopy(buf, pos, b, off, len);
          // 设置下一个要读的字节开始位置
          pos += len;
          return len;
      }

  ```
  - mark(int readAheadLimit)设置当前流的mark位置,并且里面参数无效，看源码就知道了
  ```
      public void mark(int readAheadLimit) {
          mark = pos;
      }
  ```
###应用场景
- 问题
  - 一般，我们需要先访问服务器或本地的文件或其他文件，把其数据以二进制读取到内存中，
  然后在再以输入流的形式发送给客户端。这样存在一个问题。我们从网络上获取的还要先存在本地，然后
  在读取，再发送，这样做是不是很麻烦，而上面两个流的出现就可以完美解决这个问题。
- 解决
  - ByteArrayInputStream将内建缓存数组作为流的目的地
  - ByteArrayOutputStream将内建缓存数组作为流的数据源
  - 解决  
  将从网络上读取的文件读取到ByteArrayInputStream将内建缓存数组中，然后直接再以
  输出流的形式发送给客户端。
- 优点
  - 提高了效率  
- 用途
  - 创建临时文件
  - 无需访问磁盘，把数据进行读取，写出
###总结及问题
 - ByteArrayInputStream、ByteArrayOutputStream的本质都是对内置字节数组的操作，其中包含了
 读取字节大小，toString，写入另外一个输出流及清空缓存区等；
 - ByteArrayInputStream中的count属性，不是代表buf中可读字节总数，它是正数或0，并且不应大于 buf 的长度
 - 内建数组严格遵守“一定的顺序”