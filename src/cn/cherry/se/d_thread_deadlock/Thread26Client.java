/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_deadlock;

/**
 * 结论：wait()方法会释放锁
 *
 * @author Leon
 * @version 2018/5/8 14:59
 */
public class Thread26Client {

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread26_00 t2600 = new Thread26_00(lock);
        Thread26_00 t2601 = new Thread26_00(lock);
        t2600.start();
        Thread.sleep(2000);
        t2601.start();
    }
}
