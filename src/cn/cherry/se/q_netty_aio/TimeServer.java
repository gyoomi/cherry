/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.q_netty_aio;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/7/2 9:17
 */
public class TimeServer {
    public static void main(String[] args) {
        int port = 8090;
        AsyncTimeServerHandler handler = new AsyncTimeServerHandler(port);
        new Thread(handler, "TimeServer-001").start();
    }
}
