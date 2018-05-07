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
 * @version 2018/5/7 10:26
 */
public class Thread08_00 extends Thread {

    @Override
    public void run() {
        try {
            int value = (int)(Math.random() * 1000000);
            System.out.println(value);
            Thread.sleep(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
