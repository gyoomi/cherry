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
 * @version 2018/5/7 15:42
 */
public class Thread16_00 extends Thread {

    private Thread16Domain td;

    public Thread16_00(Thread16Domain td){
        this.td = td;
    }

    @Override
    public void run() {
        td.testMethod();
    }
}
