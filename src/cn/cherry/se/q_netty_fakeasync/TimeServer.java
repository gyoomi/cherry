/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.q_netty_fakeasync;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/6/28 9:45
 */
public class TimeServer {

    public static void main(String[] args) {
        int port = 9999;
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("The time server start in port：" + port);
            Socket socket = null;
            // 创建I/O任务线程池
            TimeServerHandlerExecutePool singleExectorPool = new TimeServerHandlerExecutePool(50, 1000);
            while (true) {
                socket = server.accept();
                // new Thread(new TimeServerHandlerTest(socket)).start();
                // 删除原来的代码块
                singleExectorPool.execute(new TimeServerHandlerTest(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 所有的流必须要有正确关闭的方法，不然会出问题
            if (server != null) {
                System.out.println("The time server closedd");
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                server = null;
            }
        }
    }
}
