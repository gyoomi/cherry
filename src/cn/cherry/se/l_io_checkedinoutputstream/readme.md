###介绍
- 定义
  - 这是两个过滤流，用于维护数据校验和。校验和是用于维护数据完整性的一项技术。
  - 先来简单聊聊校验和，校验和(checksum)，是冗余校验的一种形式。 它是通过错误检测方法，对经过空间（如通信）或者时间（如计算机存储）传送的数据的完整性进行检查的一种简单方法。
    计算机领域常见的校验和的方法有：  
    
    循环冗余校验  
    MD5  
    SHA家族  
    Checksum 的这一特性通常用于校验文件下载。如果文件的提供者创建了一个MD5或者SHA 的Checksum文件, 使用者计算得出自己的checksum 文件，与提供者的Checksum文件进行比较，就可以知道文件是否完整。  
###案例
```
public class Test {

    public static void main(String[] args) throws Exception {
        checkIn();
        // 222957957
        // checkOut();
    }

    public static void checkIn() throws Exception {
        FileInputStream in = new FileInputStream("d:\\1.txt");
        CheckedInputStream cis = new CheckedInputStream(in, new CRC32());
        byte[] arr = new byte[1024*8];
        while ((cis.read(arr)) != -1) {}
        in.close();
        cis.close();
        System.out.println(cis.getChecksum().getValue());
    }

    public static void checkOut() throws Exception {
        OutputStream out = new FileOutputStream("d:\\1.txt");
        CheckedOutputStream cos = new CheckedOutputStream(out, new CRC32());
        String str = "hello world";
        cos.write(str.getBytes(), 0, str.length());
        out.close();
        cos.close();
        System.out.println(cos.getChecksum().getValue());
    }
}
```