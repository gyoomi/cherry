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
 * @version 2018/5/7 13:41
 */
public class Thread11_00 extends Thread {

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            Thread.yield();
            i++;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("用时：" + (endTime - startTime) + "毫秒");
    }
}
