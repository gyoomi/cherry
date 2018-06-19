/**
 * Copyright © 2018, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.l_nio_io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.channels.FileChannel;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/6/19 21:38
 */
public class Demo00 {

    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("D:\\1.txt");
        FileOutputStream out = new FileOutputStream("d:\\test.txt");
        FileChannel inChannel = in.getChannel();
        FileChannel outChannel = out.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true) {
            buffer.clear();
            int c = inChannel.read(buffer);
            if (c == -1) {
                break;
            }
            buffer.flip();
            outChannel.write(buffer);
        }
        in.close();
        out.close();
    }

    public static void test01() throws Exception {
        FileOutputStream out = new FileOutputStream("D:\\1.txt");
        FileChannel channel = out.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put("java nio".getBytes());
        buffer.flip();
        channel.write(buffer);
        channel.close();
        out.close();
        System.out.println("over");
    }

    public static void test02() throws Exception {
        FloatBuffer buffer = FloatBuffer.allocate(10);
        for (int i = 0; i < buffer.capacity(); i++) {
            float f=(float)((float)i/10*(2*Math.PI));
            buffer.put(f);
        }
        buffer.flip();
        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
    }
}
