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
 * @version 2018/5/7 10:16
 */
public class Client07 {

    public static void main(String[] args) throws InterruptedException{
        Thread07_00 t0700 = new Thread07_00();
        t0700.start();
        Thread.sleep(2000);
        t0700.interrupt();
    }
}
