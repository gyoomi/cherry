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
 * @version 2018/5/8 14:44
 */
public class Thread25_01 extends Thread {

    private Object lock;

    public Thread25_01(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("开始------notify time = " + System.currentTimeMillis());
            lock.notify();
            System.out.println("结束------notify time = " + System.currentTimeMillis());
        }
    }
}
