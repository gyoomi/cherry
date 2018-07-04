/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.q_netty_nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/6/29 10:14
 */
public class TimeClientHandle implements Runnable {

    private String host;

    private int port;

    private SocketChannel sc;

    private Selector selector;

    private volatile boolean stop;

    public TimeClientHandle(String host, int port) {
        this.host = host == null ? "127.0.0.1" : host;
        this.port = port;
        try {
            selector = Selector.open();
            sc = SocketChannel.open();
            sc.configureBlocking(false);
        } catch (IOException e) {
            e.printStackTrace();
            // It will exit if the exception happened
            System.exit(1);
        }
    }

    @Override
    public void run() {
        // If connect successful,do it
        // It will not connect again
        try {
            doConnect();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        // If connect failed, it will select all the time
        while (!stop) {
            try {
                selector.select(1000);
                Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                SelectionKey key = null;
                while (it.hasNext()) {
                    key = it.next();
                    it.remove();
                    try  {
                        handleInput(key);
                    } catch (Exception e) {
                        if (key != null) {
                            key.cancel();
                            if (key.channel() != null) {
                                key.channel().close();
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }

        // Close the selector
        if (selector != null) {
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void handleInput(SelectionKey key) throws IOException {
        if (key.isValid()) {
            SocketChannel sc = (SocketChannel) key.channel();
            if (key.isConnectable()) {
                if (sc.finishConnect()) {
                    // 连接成功
                    sc.register(selector, SelectionKey.OP_READ);
                    doWrite(sc);
                } else {
                    // 连接失败，进程退出
                    System.exit(1);
                }
            }

            if (key.isReadable()) {
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                int read = sc.read(buffer);
                if (read > 0) {
                    buffer.flip();
                    byte[] bytes = new byte[buffer.remaining()];
                    buffer.get(bytes);
                    String body = new String(bytes, "UTF-8");
                    System.out.println("Now is：" + body);
                    this.stop = true;
                } else if (read < 0) {
                    // 链路关闭
                    key.cancel();
                    sc.close();
                } else {
                    // 读到0字节，忽略
                    ;
                }
            }
        }
    }

    public void doConnect() throws IOException {
        boolean flag = sc.connect(new InetSocketAddress(host, port));
        if (flag) {
            // Connect successful
            sc.register(selector, SelectionKey.OP_READ);
            doWrite(sc);
        } else {
            // Failed Connected,wait the async message
            sc.register(selector, SelectionKey.OP_CONNECT);
        }
    }

    public void doWrite(SocketChannel sc) throws IOException {
        // 存在半写包问题，需要优化
        byte[] req = "query time order".getBytes();
        ByteBuffer buffer = ByteBuffer.allocate(req.length);
        buffer.put(req);
        buffer.flip();
        sc.write(buffer);
        if (!buffer.hasRemaining()) {
            System.out.println("The client send order successful.");
        }
    }
}
