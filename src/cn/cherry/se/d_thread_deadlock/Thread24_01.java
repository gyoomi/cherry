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
 * @version 2018/5/8 13:44
 */
public class Thread24_01 extends Thread {

    private Thread24Domain td;

    public Thread24_01(Thread24Domain td) {
        this.td = td;
    }

    @Override
    public void run() {
        try {
            td.rightLeft();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
