/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.q_netty_nio;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/6/29 9:35
 */
public class TimeServer {

    public static void main(String[] args) {
        int port = 8090;
        MultiplexerTimeServer multiplexerTimeServer = new MultiplexerTimeServer(port);
        new Thread(multiplexerTimeServer, "NIO-Time server-001").start();
    }
}
