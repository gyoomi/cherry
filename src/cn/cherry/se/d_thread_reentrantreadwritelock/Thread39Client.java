/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_reentrantreadwritelock;

/**
 * 大型网站中很重要的一块内容就是数据的读写，ReentrantLock虽然具有完全互斥排他的效果（即同一时间只有一个线程正在执行lock后面的任务），但是效率非常低。所以在JDK中提供了一种读写锁ReentrantReadWriteLock，使用它可以加快运行效率。
 *
 * 读写锁表示两个锁，一个是读操作相关的锁，称为共享锁；另一个是写操作相关的锁，称为排他锁。我把这两个操作理解为三句话：
 *   1、读和读之间不互斥，因为读操作不会有线程安全问题
 *   2、写和写之间互斥，避免一个写操作影响另外一个写操作，引发线程安全问题
 *   3、读和写之间互斥，避免读操作的时候写操作修改了内容，引发线程安全问题
 *
 * 总结起来就是，多个Thread可以同时进行读取操作，但是同一时刻只允许一个Thread进行写入操作。
 *
 * @author Leon
 * @version 2018/5/9 15:15
 */
public class Thread39Client {

    public static void main(String[] args) {
        Thread39Domain td = new Thread39Domain();
        Runnable rn1 = new Runnable() {
            @Override
            public void run() {
                td.read();
            }
        };
        Thread t0 = new Thread(rn1);
        Thread t1 = new Thread(rn1);
        t0.start();
        t1.start();
    }
}
