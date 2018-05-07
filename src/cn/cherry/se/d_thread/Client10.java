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
 * @version 2018/5/7 11:58
 */
public class Client10 {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("begin = " + startTime);
        Thread10_00 t1000 = new Thread10_00();
        t1000.start();
        long endTime = System.currentTimeMillis();
        System.out.println("end = " + endTime);

    }
}
