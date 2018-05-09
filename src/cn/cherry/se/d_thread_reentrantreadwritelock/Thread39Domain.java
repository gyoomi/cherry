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
 * @version 2018/5/9 15:11
 */
public class Thread39Domain extends ReentrantReadWriteLock {

    public void read() {
        try {
            readLock().lock();
            System.out.println("ThreadName = " + Thread.currentThread().getName() + "获得读锁，时间为 = " + System.currentTimeMillis());
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock().unlock();
        }
    }
}
