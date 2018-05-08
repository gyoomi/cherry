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
 * @version 2018/5/8 15:29
 */
public class Thread28Domain {

    public void testMethod(Object lock) {
        try {
            synchronized (lock) {
                System.out.println("Begin wait()...");
                lock.wait();
                System.out.println("End wait()...");
            }
        } catch (InterruptedException e) {
            System.out.println("wait() 被打断了！！！");
            e.printStackTrace();
        }
    }
}
