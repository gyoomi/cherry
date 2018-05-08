/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_volatile;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/5/8 11:34
 */
public class Thread23_00 extends Thread {

    private Thread23Domain td;

    public Thread23_00(Thread23Domain td) {
        this.td = td;
    }

    @Override
    public void run() {
        td.addNum();
    }
}
