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
 * @version 2018/5/7 15:56
 */
public class Thread17_00 extends Thread {

    private Thread17Domain td;

    public Thread17_00(Thread17Domain td){
        this.td = td;
    }

    @Override
    public void run() {
        try {
            td.doLongTimeTask();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
