/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_reentrantlock;

/**
 * getHoldCount()
 *     返回的是当前线程调用lock()的次数
 *
 * @author Leon
 * @version 2018/5/9 14:00
 */
public class Thread34Client {

    public static void main(String[] args) {
        Thread34Domain td = new Thread34Domain();
        Thread34_00 t3400 = new Thread34_00(td);
        t3400.start();
    }
}
