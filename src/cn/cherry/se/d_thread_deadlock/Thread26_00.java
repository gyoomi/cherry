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
 * @version 2018/5/8 14:58
 */
public class Thread26_00 extends Thread {

    private Object lock;

    public Thread26_00(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        Thread26Domain td = new Thread26Domain();
        td.testMethod(lock);
    }
}
