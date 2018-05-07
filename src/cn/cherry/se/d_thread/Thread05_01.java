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
 * @version 2018/5/7 9:56
 */
public class Thread05_01 extends Thread {

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {

        }
        long endTime = System.currentTimeMillis();
        System.out.println("◆◆◆◆◆ thread1 use time =" + (endTime - startTime));
    }
}
