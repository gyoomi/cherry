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
 * @version 2018/5/9 13:52
 */
public class Thread34_00 extends Thread {

    private Thread34Domain td;

    public Thread34_00(Thread34Domain td) {
        this.td = td;
    }

    @Override
    public void run() {
        td.method1();
    }
}
