/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.l_nio_channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/6/22 14:59
 */
public class WerClient {

    public static void main(String[] args) {
        test01();
    }

    public static void test01() {
        SocketChannel socketChannel = null;
        try {
            socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 8000));
            ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
            writeBuffer.put("hello world".getBytes());
            // 写模式转读模式
            writeBuffer.flip();
            socketChannel.write(writeBuffer);
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
