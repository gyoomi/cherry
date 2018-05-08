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
 * @version 2018/5/8 15:57
 */
public class Thread29Domain {

    public void testMethod(Object lock) {
        try {
            synchronized (lock) {
                System.out.println("Begin wait --- " + Thread.currentThread().getName());
                lock.wait();
                System.out.println("End wait --- " + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
