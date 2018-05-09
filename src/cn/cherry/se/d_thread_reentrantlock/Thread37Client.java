/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_reentrantlock;

/**
 * 1.isHeldByCurrentThread()表示此对象监视器是否由当前线程保持
 * 2.isLocked()表示此对象监视器是否由任意线程保持
 *
 * @author Leon
 * @version 2018/5/9 14:37
 */
public class Thread37Client {

    public static void main(String[] args) {
        Thread37Domain td = new Thread37Domain();
        Runnable rn1 = new Runnable(){
            @Override
            public void run() {
                td.testMethod();
            }
        };
        Runnable rn2 = new Runnable(){
            @Override
            public void run() {
                td.testIsLock();
            }
        };

        Thread t0 = new Thread(rn1);
        Thread t1 = new Thread(rn2);
        t0.start();
        t1.start();

    }
}
