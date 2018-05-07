/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_lock;

/**
 * synchronized块获得的是对象锁，那么如果线程1访问了一个对象方法A的synchronized块，线程2对于同一对象同步方法B的访问应该是会被阻塞的，
 * 因为线程2访问同一对象的同步方法B的时候将会尝试去获取这个对象的对象锁，但这个锁却在线程1这里
 *
 * @author Leon
 * @version 2018/5/7 17:14
 */
public class Thread19Client {

    public static void main(String[] args) throws Exception{
        Thread19Domain td = new Thread19Domain();
        Thread19_00 t1900 = new Thread19_00(td);
        Thread19_01 t1901 = new Thread19_01(td);
        t1900.start();
        Thread.sleep(1000);
        t1901.start();
    }
}
