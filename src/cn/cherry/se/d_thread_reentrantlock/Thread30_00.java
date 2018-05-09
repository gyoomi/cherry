/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_reentrantlock;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/5/9 10:33
 */
public class Thread30_00 extends Thread {

    private Thread30Domain td;

    public Thread30_00(Thread30Domain td) {
        this.td = td;
    }

    @Override
    public void run() {
        td.testMethod();
    }
}
