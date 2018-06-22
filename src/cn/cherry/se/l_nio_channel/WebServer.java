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
 * @version 2018/6/22 14:39
 */
public class WebServer {

    public static void main(String[] args) {
        test01();
    }

    public static void test01() {
        try {
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.socket().bind(new InetSocketAddress("127.0.0.1", 8000));
            SocketChannel socketChannel = ssc.accept();

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            socketChannel.read(buffer);
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.println((char)buffer.get());
            }
            socketChannel.close();
            ssc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
