/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread;

/**
 * isAlive()方法的使用
 *
 * @author Leon
 * @version 2018/5/7 9:29
 */
public class Thread03_00 extends Thread {

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + " is running..." + this);
        System.out.println("run = " + this.isAlive());
        for (int i = 0; i < 10000; i++) {
            if (i == 10000){
                break;
            }
        }
    }
}
