/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_lock;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/5/7 17:04
 */
public class Thread19Domain {

    public void otherMethod() {
        System.out.println("------------otherMethod-------------");
    }

    public void methodA() {
        synchronized (this) {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Thread19Domain ThreadName = " + Thread.currentThread().getName() + " i = " + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
