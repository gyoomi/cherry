/**
 * Copyright © 2018, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.q_netty_nio;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/6/29 22:09
 */
public class TimeClient {

    public static void main(String[] args) {
        int port = 8090;
        new Thread(new TimeClientHandle("127.0.0.1", port), "TimeClient-001").start();
    }

}
