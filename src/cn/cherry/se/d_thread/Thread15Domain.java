/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread;

/**
 * synchronized锁重入
 *
 * @author Leon
 * @version 2018/5/7 15:27
 */
public class Thread15Domain {

    public synchronized void print1(){
        System.out.println("Thread15Domain print1()");
        print2();
    }

    public synchronized void print2(){
        System.out.println("Thread15Domain print2()");
        print3();
    }

    public synchronized void print3(){
        System.out.println("Thread15Domain print3()");
    }
}
