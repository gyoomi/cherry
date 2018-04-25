/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/4/25 17:04
 */
public class Client {
    public static void main(String[] args) {
        Thread01 t1 = new Thread01();
        t1.start();
        Thread02 t2 = new Thread02();
        Thread t001  = new Thread(t2);
        t001.start();
    }
}
