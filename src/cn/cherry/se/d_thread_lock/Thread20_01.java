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
 * @version 2018/5/8 9:19
 */
public class Thread20_01 extends Thread {

    private Thread20Domain td;

    public Thread20_01(Thread20Domain td){
        this.td = td;
    }

    @Override
    public void run() {
        td.setUsernamePassword("B", "BB");
    }
}
