/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_lock;

/**
 * 1.两个synchronized块之间具有互斥性
 * 2.synchronized块获得的是一个对象锁，换句话说，synchronized块锁定的是整个对象。
 *
 * @author Leon
 * @version 2018/5/7 16:53
 */
public class Thread18Client {

    public static void main(String[] args) {
        Thread18Domain td = new Thread18Domain();
        Thread18_00 t1800 = new Thread18_00(td);
        Thread18_01 t1801 = new Thread18_01(td);
        t1800.start();
        t1801.start();
    }
}
