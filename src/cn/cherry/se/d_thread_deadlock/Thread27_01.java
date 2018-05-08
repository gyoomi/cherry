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
 * @version 2018/5/8 15:15
 */
public class Thread27_01 extends Thread {

    private Object lock;

    public Thread27_01(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        Thread27Domain td = new Thread27Domain();
        td.testNotifyMethod(lock);
    }
}
