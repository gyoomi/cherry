/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/5/7 14:02
 */
public class Thread13_01 extends Thread {

    private Thread13Domain td;

    public Thread13_01(Thread13Domain td){
        this.td = td;
    }
    @Override
    public void run() {
        this.td.addNum("b");
    }
}
