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
 * @version 2018/6/22 15:20
 */
public class GatherWebClient {

    public static void main(String[] args) {
        SocketChannel socketChannel = null;
        try {
            socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 8000));
            ByteBuffer buffer1 = ByteBuffer.allocate(1024);
            ByteBuffer buffer2 = ByteBuffer.allocate(16);
            buffer1.put("hello".getBytes());
            buffer2.put("world".getBytes());
            buffer1.flip();
            buffer2.flip();
            ByteBuffer[] array = {buffer1, buffer2};
            socketChannel.write(array);
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
