/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_lock;

/**
 * 对printC()方法的调用和对printA()方法、printB()方法的调用时异步的，这说明了静态同步方法和非静态同步方法持有的是不同的锁，
 * 前者是类锁，后者是对象锁。
 *
 * @author Leon
 * @version 2018/5/8 10:06
 */
public class Thread21Client {

    public static void main(String[] args) {
        Thread21Domain td = new Thread21Domain();
        Thread21_00 t2100 = new Thread21_00(td);
        Thread21_01 t2101 = new Thread21_01();
        Thread21_02 t2102 = new Thread21_02();
        t2100.start();
        t2101.start();
        t2102.start();
    }
}
