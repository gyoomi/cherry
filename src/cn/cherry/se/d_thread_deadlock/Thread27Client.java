/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_deadlock;

/**
 * notify()方法不释放锁
 *
 * @author Leon
 * @version 2018/5/8 15:17
 */
public class Thread27Client {

    public static void main(String[] args) {
        Object lock = new Object();
        Thread27_00 t2700 = new Thread27_00(lock);
        Thread27_01 t2701 = new Thread27_01(lock);
        Thread27_01 t2702 = new Thread27_01(lock);
        t2701.start();
        t2702.start();
        t2700.start();
    }
}
