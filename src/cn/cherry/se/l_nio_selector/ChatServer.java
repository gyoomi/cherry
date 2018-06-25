/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.l_nio_selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/6/25 9:31
 */
public class ChatServer implements Runnable {

    private Selector selector;
    private SelectionKey serverKey;
    private Vector<String> usernames;
    private static final int PORT = 9999;

    public ChatServer() {
        usernames = new Vector<>();
        init();
    }

    public void init() {
        try {
            selector = Selector.open();
            // 创建ServerSocketChannel通道
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ServerSocket socket = ssc.socket();
            socket.bind(new InetSocketAddress(PORT));
            // 绑定到selector上
            ssc.configureBlocking(false);
            serverKey = ssc.register(selector, SelectionKey.OP_ACCEPT);
            printInfo("ChatServer Start...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                // 获取就绪的channel个数
                int count = selector.select();
                if (count > 0) {
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey selectionKey = iterator.next();
                        // 如果此key通道是等待新socket连接
                        if (selectionKey.isAcceptable()) {
                            System.out.println(selectionKey.toString() + "：接收消息");
                            // 必须进行移除，否则会出错
                            iterator.remove();
                            ServerSocketChannel ssc = (ServerSocketChannel) selectionKey.channel();
                            // 接收socket
                            SocketChannel socket = ssc.accept();
                            socket.configureBlocking(false);
                            // 把此channel加入到selector中，然后在开始读取数据
                            socket.register(selector, SelectionKey.OP_READ);
                        }

                        // 此key通道有数据并且是可读的
                        if (selectionKey.isValid() && selectionKey.isReadable()) {
                            System.out.println(selectionKey.toString() + "：读");
                            readMsg(selectionKey);
                        }

                        // 此key的通道是可写的
                        if (selectionKey.isValid() && selectionKey.isWritable()) {
                            System.out.println(selectionKey.toString() + "：写");
                            writeMsg(selectionKey);
                        }

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printInfo(String message) {
        System.out.println("["+new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()) +"]：" + message);
    }

    public void readMsg(SelectionKey key) {
        SocketChannel socketChannel = null;
        try {
            socketChannel = (SocketChannel) key.channel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            // 假如客户端关闭了通道，这里在对该通道read数据，会发生IOException，捕获到Exception后，关闭掉该channel，取消掉该key
            int read = socketChannel.read(buffer);
            StringBuilder sb = new StringBuilder();
            // 如果读到数据
            if (read > 0) {
                buffer.flip();
                sb.append(new String(buffer.array(), 0, read));
            }
            String msg = sb.toString();

            // 1.如果此数据是连接客户端发送的数据
            if (msg.indexOf("open_") != -1) {
                // 取出名字
                String name = msg.substring(5);
                printInfo(name + "--->Online");
                usernames.add(name);
                // 如果不是服务器的套接字key,将此数据设置到key中
                // 并更新此key感兴趣的事情
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey sKey = iterator.next();
                    if (key != sKey) {
                        sKey.attach(usernames);
                        sKey.interestOps(sKey.interestOps() | SelectionKey.OP_WRITE);
                    }
                }
                // 2.如果此数据是下线时的数据
            } else if (msg.indexOf("exit_") != -1) {
                String name = msg.substring(5);
                usernames.remove(name);
                key.attach("close");
                // 退出的当前channel加上close的标示，并把兴趣转为写，如果write中收到了close，则中断channel的链接
                key.interestOps(SelectionKey.OP_WRITE);
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey sKey = iterator.next();
                    sKey.attach(name);
                    sKey.interestOps(sKey.interestOps() | SelectionKey.OP_WRITE);
                }
            } else {
                // 3.聊天的数据
                String uname = msg.substring(0, msg.indexOf("^"));
                msg = msg.substring(msg.indexOf("^") + 1);
                printInfo("("+uname+")说：" + msg);
                String smsg = uname + " " + new SimpleDateFormat().format(new Date()) + "\n  " + msg + "\n";
                Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
                while(iter.hasNext()){
                    SelectionKey sKey = iter.next();
                    sKey.attach(smsg);
                    sKey.interestOps(sKey.interestOps() | SelectionKey.OP_WRITE);
                }
            }
        buffer.clear();
        } catch (IOException e) {
            //当客户端关闭channel时，服务端再往通道缓冲区中写或读数据，都会报IOException，解决方法是：在服务端这里捕获掉这个异常，并且关闭掉服务端这边的Channel通道
            key.cancel();
            try {
                socketChannel.socket().close();
                socketChannel.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    public void writeMsg(SelectionKey key) {
        try {
            SocketChannel socketChannel = (SocketChannel) key.channel();
            Object attachment = key.attachment();
            // 获取key值后，要把key值置空，避免影响下一次的使用
            key.attach(null);
            socketChannel.write(ByteBuffer.wrap(attachment.toString().getBytes()));
            key.interestOps(SelectionKey.OP_READ);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
