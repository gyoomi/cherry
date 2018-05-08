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
 * @version 2018/5/8 13:40
 */
public class Thread24_00 extends Thread {
    private Thread24Domain td;

    public Thread24_00(Thread24Domain td) {
        this.td = td;
    }

    @Override
    public void run() {
        try {
            td.leftRight();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
