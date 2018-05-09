/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/5/9 14:05
 */
public class Thread35Domain {

    public ReentrantLock lock = new ReentrantLock();

    public void testMethod() {
        try {
            lock.lock();
            System.out.println("ThreadName " + Thread.currentThread().getName() + "进入方法了");
            System.out.println("是否是公平锁? " + lock.isFair());
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
