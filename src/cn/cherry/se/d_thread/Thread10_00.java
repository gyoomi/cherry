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
 * @version 2018/5/7 11:54
 */
public class Thread10_00 extends Thread {

    @Override
    public void run() {
        System.out.println("run Thread = " + this.getName() + " begin");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("run Thread = " + this.getName() + " end");
    }
}
