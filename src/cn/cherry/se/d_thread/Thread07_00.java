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
 * @version 2018/5/7 10:15
 */
public class Thread07_00 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 499999; i++) {
            System.out.println("i = " + i);
        }
    }
}
