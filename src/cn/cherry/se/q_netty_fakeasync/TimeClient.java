/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.q_netty_fakeasync;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/6/28 9:58
 */
public class TimeClient {

    public static void main(String[] args) {
        int port = 9999;
        BufferedReader in = null;
        PrintWriter out = null;
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 一定要设置自动刷新缓冲区
            out = new PrintWriter(socket.getOutputStream(), true);
            out.println("query time order");
            System.out.println("The client send order successful");
            String rs = in.readLine();
            System.out.println("Now is ：" + rs);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    // 先关闭
                    socket.close();
                } catch (IOException e) {
                }
                // 置空
                socket = null;
            }
        }
    }
}
