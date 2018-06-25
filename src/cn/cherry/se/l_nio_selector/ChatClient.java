/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.l_nio_selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Chat Client
 *
 * @author Leon
 * @version 2018/6/25 16:58
 */
public class ChatClient {

    private static final String HOST = "127.0.0.1";
    private static final int PORT = 9999;
    private SocketChannel socketChannel;
    private static ChatClient chatClient;

    private static byte[] lock = new byte[1];

    private ChatClient() throws IOException {
        socketChannel = SocketChannel.open();
        socketChannel.bind(new InetSocketAddress(HOST, PORT));
        socketChannel.configureBlocking(false);
    }

    public static ChatClient getInstance() {
        if (chatClient == null) {
            synchronized (lock) {
                if (chatClient == null) {
                    try {
                        chatClient = new ChatClient();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return chatClient;
    }

    /**
     * Send message
     *
     * @param msg
     */
    public void sendMsg(String msg) {
        try {
            socketChannel.write(ByteBuffer.wrap(msg.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String receiveMsg() {
        String msg = null;
        try {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            StringBuilder sb = new StringBuilder();
            int count = 0;
            // 多次连续读取，直至读完为止
            while ((count = socketChannel.read(buffer)) > 0) {
                sb.append(new String(buffer.array(), 0, count));
            }

            // 读到数据
            if (sb.length() > 0) {
                msg = sb.toString();
                if (sb.toString().equals("close")) {
                    // 不过不sleep会导致ioException的发生,因为如果这里直接关闭掉通道，在server里，
                    // 该channel在read（buffer）时会发生读取异常，通过sleep一段时间，使得服务端那边的channel先关闭，客户端
                    // 的channel后关闭，这样就能防止read(buffer)的ioException
                    // 但是这是一种笨方法
                    // Thread.sleep(100);
                    // 更好的方法是，在readBuffer中捕获异常后，手动进行关闭通道
                    socketChannel.socket().close();
                    socketChannel.close();
                    msg = null;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return msg;
    }
}
