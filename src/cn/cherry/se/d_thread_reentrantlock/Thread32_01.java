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
 * @version 2018/5/9 11:33
 */
public class Thread32_01 extends Thread {

    private Thread32Domain td;

    public Thread32_01(Thread32Domain td) {
        this.td = td;
    }

    @Override
    public void run() {
        td.signal();
    }
}
