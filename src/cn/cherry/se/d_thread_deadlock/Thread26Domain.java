/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_deadlock;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/5/8 14:55
 */
public class Thread26Domain {

    public void testMethod(Object lock) {
        try {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " Begin wait()...");
                lock.wait();
                System.out.println(Thread.currentThread().getName() + " End wait()...");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
