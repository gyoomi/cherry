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
 * @version 2018/5/7 11:12
 */
public class Thread09_01 extends Thread {

    static {
        System.out.println("Thread09_01 static code start");
        System.out.println("Thread09_01 static code:" + Thread.currentThread().getName());
        System.out.println("Thread09_01 static code end");
    }

    public Thread09_01(){
        System.out.println("Thread09_01 constructor start");
        System.out.println("Thread09_01 constructor code:" + Thread.currentThread().getName());
        System.out.println("Thread09_01: " + this.getName());
        System.out.println("Thread09_01 constructor end");
    }
    @Override
    public void run() {
        System.out.println("run start");
        System.out.println("run currentThread:" + Thread.currentThread().getName());
        System.out.println("run : " + this.getName());
        System.out.println("run end");
    }
}
