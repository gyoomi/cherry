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
 * @version 2018/5/9 10:26
 */
public class Thread30Domain {

    private Lock lock = new ReentrantLock();

    public void testMethod() {
        lock.lock();
        for (int i = 1; i < 4; i++) {
            System.out.println("ThreadName " + Thread.currentThread().getName() + "   i = " + i);
        }
        lock.unlock();
    }
}
