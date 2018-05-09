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
 * @version 2018/5/9 14:09
 */
public class Thread35_00 extends Thread {

    private Thread35Domain td;

    public Thread35_00(Thread35Domain td) {
        this.td = td;
    }

    @Override
    public void run() {
        td.testMethod();
    }
}
