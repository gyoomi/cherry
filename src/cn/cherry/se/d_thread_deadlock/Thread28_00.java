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
 * @version 2018/5/8 15:32
 */
public class Thread28_00 extends Thread {

    private Object lock;

    public Thread28_00(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        Thread28Domain td = new Thread28Domain();
        td.testMethod(lock);
    }
}
