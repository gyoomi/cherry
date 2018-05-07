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
 * @version 2018/5/7 17:10
 */
public class Thread19_00 extends Thread {

    private Thread19Domain td;

    public Thread19_00(Thread19Domain td) {
        this.td = td;
    }

    @Override
    public void run() {
        td.methodA();
    }
}
