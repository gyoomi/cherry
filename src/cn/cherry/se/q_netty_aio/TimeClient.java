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
 * @version 2018/7/2 13:58
 */
public class TimeClient {

    public static void main(String[] args) {
       int port = 8090;
       new Thread(new AsyncTimeClientHandler("127.0.0.1", port), "Time client-001").start();
    }

}
