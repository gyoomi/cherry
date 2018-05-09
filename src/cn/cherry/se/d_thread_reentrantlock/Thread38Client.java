/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_reentrantlock;

/**
 * 1.tryLock()方法的作用是，在调用try()方法的时候，如果锁没有被另外一个线程持有，那么就返回true，否则返回false
 * 2.tryLock(long timeout, TimeUnit unit)是tryLock()另一个重要的重载方法，表示如果在指定等待时间内获得了锁，则返回true，否则返回false
 * 3.tryLock()只探测锁是否，并没有lock()的功能，要获取锁，还得调用lock()方法.
 *
 * @author Leon
 * @version 2018/5/9 14:46
 */
public class Thread38Client {

    public static void main(String[] args) {
        Thread38Domain td = new Thread38Domain();
        Runnable rn1 = new Runnable() {
            @Override
            public void run() {
                td.testMethod();
            }
        };
        Runnable rn2 = new Runnable() {
            @Override
            public void run() {
                td.testMethod();
            }
        };

        Thread t0 = new Thread(rn1);
        Thread t1 = new Thread(rn2);
        t0.start();
        t1.start();
    }
}
