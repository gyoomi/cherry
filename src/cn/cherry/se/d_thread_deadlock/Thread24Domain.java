/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_deadlock;

/**
 * 死锁
 *
 * @author Leon
 * @version 2018/5/8 12:00
 */
public class Thread24Domain {

    private final Object right = new Object();
    private final Object left = new Object();

    public void rightLeft() throws Exception {
        synchronized (left) {
            Thread.sleep(200);
            synchronized (right) {
                System.out.println("rightLeft end...");
            }
        }
    }

    public void leftRight() throws Exception {
        synchronized (right) {
            Thread.sleep(200);
            synchronized (left) {
                System.out.println("leftRight end...");
            }
        }
    }
}
