/**
 * Copyright © 2018, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.l_nio_channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 利用channel完成文件的复制
 *
 * @author Leon
 * @version 2018/6/22 22:05
 */
public class FileChannelDemo {

    public static void main(String[] args) throws Exception {
        test03();
    }

    public static void test03() throws Exception {

    }

    /**
     * 直接缓冲区完成文件的复制
     *
     * @throws Exception
     */
    public static void test02() throws Exception {
        FileChannel inChannel = FileChannel.open(Paths.get("d:\\design.rar"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("D:\\test1.rar"), StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        // 内存映射文件
        MappedByteBuffer inMappedByteBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMappedByteBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

        //直接对缓冲区进行数据读写操作
        byte[] arr = new byte[inMappedByteBuffer.limit()];
        inMappedByteBuffer.get(arr);
        outMappedByteBuffer.put(arr);

        inChannel.close();
        outChannel.close();
        System.out.println("over");
    }

    /**
     * 文件复制
     *
     * @throws Exception
     */
    public void test01() throws Exception {
        FileInputStream in = new FileInputStream("d:\\design.rar");
        FileOutputStream out = new FileOutputStream("d:\\test.rar");
        FileChannel inChannel = in.getChannel();
        FileChannel outChannel = out.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (inChannel.read(buffer) != -1) {
            // 切换读写的数据模式
            buffer.flip();
            outChannel.write(buffer);
            // 清空缓冲区
            buffer.clear();
        }
        inChannel.close();
        outChannel.close();
        in.close();
        out.close();
        System.out.println("over");
    }

}
