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
 * @version 2018/5/7 16:50
 */
public class Thread18_00 extends Thread {

    private Thread18Domain td;

    public Thread18_00(Thread18Domain td){
        this.td = td;
    }

    @Override
    public void run() {
        td.methodA();
    }
}
