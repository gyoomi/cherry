/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/5/9 11:52
 */
public class Thread33Domain {

    private Lock lock = new ReentrantLock(false);

    public void testMethod() {
        try {
            lock.lock();
            System.out.println("ThreadName " + Thread.currentThread().getName() + "获得锁");
        } finally {
            lock.unlock();
        }
    }
}
