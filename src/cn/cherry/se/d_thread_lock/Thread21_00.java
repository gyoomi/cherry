/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_lock;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/5/8 10:03
 */
public class Thread21_00 extends Thread {

    private Thread21Domain td;

    public Thread21_00(Thread21Domain td) {
        this.td = td;
    }

    @Override
    public void run() {
        td.printC();
    }
}
