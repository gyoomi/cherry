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
 * @version 2018/5/9 11:14
 */
public class Thread31_00 extends Thread {

    private Thread31Domain td;

    public Thread31_00(Thread31Domain td) {
        this.td = td;
    }

    @Override
    public void run() {
        td.methodA();
    }
}
