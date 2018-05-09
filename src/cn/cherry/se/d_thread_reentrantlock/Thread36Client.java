/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_reentrantlock;

/**
 * 1.hasQueuedThread(Thread thread)用来查询指定的线程是否正在等待获取指定的对象监视器
 * 2.hasQueuedThreads()用于查询是否有线程正在等待获取指定的对象监视器
 *
 * @author Leon
 * @version 2018/5/9 14:24
 */
public class Thread36Client {

    public static void main(String[] args) throws InterruptedException {
        Thread36Domain td = new Thread36Domain();
        Runnable rn = new Runnable(){
            @Override
            public void run() {
                td.testMethod();
            }
        };

        Thread t0 = new Thread(rn);
        t0.start();
        Thread.sleep(500);
        Thread t1 = new Thread(rn);
        t1.start();
        Thread.sleep(500);
        Thread t2 = new Thread(rn);
        t2.start();
        Thread.sleep(500);

        System.out.println("t0 is waiting? " + td.hasQueuedThread(t0));
        System.out.println("t1 is waiting? " + td.hasQueuedThread(t1));
        System.out.println("t2 is waiting? " + td.hasQueuedThread(t2));
        System.out.println("is any thread waiting? " + td.hasQueuedThreads());
    }
}
