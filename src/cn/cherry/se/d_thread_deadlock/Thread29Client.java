/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_deadlock;

/**
 * 利用Object对象的notifyAll()方法可以唤醒处于同一监视器下的所有处于wait的线程
 *
 * @author Leon
 * @version 2018/5/8 16:02
 */
public class Thread29Client {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread29_00 t29001 = new Thread29_00(lock);
        Thread29_00 t29002 = new Thread29_00(lock);
        Thread29_00 t29003 = new Thread29_00(lock);
        t29001.start();
        t29002.start();
        t29003.start();
        Thread.sleep(3000);
        Thread29_01 t2901 = new Thread29_01(lock);
        t2901.start();
    }
}
