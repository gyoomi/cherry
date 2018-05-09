/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_reentrantlock;

/**
 * 1.getQueueLength()方法用于获取正等待获取此锁定的线程估计数。注意"估计"两个字，因为此方法遍历内部数据结构的同时，线程的数据可能动态变化
 * 2.isFair()用来获取此锁是否公平锁
 * 3.ReentrantLock默认的是非公平锁
 *
 * @author Leon
 * @version 2018/5/9 14:10
 */
public class Thread35Client {

    public static void main(String[] args) throws InterruptedException {
        Thread35Domain td = new Thread35Domain();
        Runnable rn = new Runnable(){
            @Override
            public void run() {
                td.testMethod();
            }
        };
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(rn);
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        Thread.sleep(2000);
        System.out.println("等待的线程的数量是：" + td.lock.getQueueLength());
    }

}
