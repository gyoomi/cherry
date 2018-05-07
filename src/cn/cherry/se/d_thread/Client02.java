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
 * @version 2018/5/7 9:30
 */
public class Client02 {

    public static void main(String[] args) throws Exception{
        Thread03_00 t3 = new Thread03_00();
        System.out.println("new = " + t3.isAlive());
        t3.start();
        Thread.sleep(3000);
        System.out.println("sleep = " + t3.isAlive());

        /**
         * output:
         *
         * new = false
         * Thread-0 is running...Thread[Thread-0,5,main]
         * run = true
         * sleep = false
         */
    }
}
