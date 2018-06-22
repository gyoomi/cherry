/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.l_nio_channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/6/22 15:28
 */
public class ScatterWebServer {

    public static void main(String[] args) {
        try {
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.socket().bind(new InetSocketAddress("127.0.0.1", 8000));
            SocketChannel socketChannel = ssc.accept();
            ByteBuffer buffer1 = ByteBuffer.allocate(8);
            ByteBuffer buffer2= ByteBuffer.allocate(16);
            ByteBuffer[] array = {buffer1, buffer2};
            socketChannel.read(array);
            buffer1.flip();
            buffer2.flip();
            while (buffer1.hasRemaining()) {
                System.out.println((char)buffer1.get());
            }
            System.out.println("----");
            while (buffer2.hasRemaining()) {
                System.out.println((char)buffer2.get());
            }

            socketChannel.close();
            ssc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
