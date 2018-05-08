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
 * @version 2018/5/8 16:00
 */
public class Thread29_00 extends Thread {

    private Object lock;

    public Thread29_00(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        Thread29Domain td = new Thread29Domain();
        td.testMethod(lock);
    }
}
