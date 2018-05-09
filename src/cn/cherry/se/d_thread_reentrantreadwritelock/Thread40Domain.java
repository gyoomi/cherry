/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_reentrantreadwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/5/9 15:21
 */
public class Thread40Domain {

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void write() {
        try {
            lock.writeLock().lock();
            System.out.println("ThreadName = " + Thread.currentThread().getName() + "获得了写锁。 Time = " + System.currentTimeMillis());
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }
}
