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
 * @version 2018/5/7 14:56
 */
public class Thread14_01 extends Thread {

    private Thread14_00Domain td;

    public Thread14_01(Thread14_00Domain td){
        this.td = td;
    }

    @Override
    public void run() {
        td.methodB();
    }
}
