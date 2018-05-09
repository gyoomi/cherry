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
 * @version 2018/5/9 14:32
 */
public class Thread37Domain extends ReentrantLock {

    public void testMethod() {
        try {
            lock();
            System.out.println("ThreadName = " + Thread.currentThread().getName() + "持有了锁。");
            System.out.println("ThreadName = " + Thread.currentThread().getName() + "是否持有了锁？" + isHeldByCurrentThread());
            System.out.println("锁（对象监视器）是否被其他线程持有？" + isLocked());
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            unlock();
        }
    }

    public void testIsLock() {
        System.out.println("ThreadName = " + Thread.currentThread().getName() + "是否持有了锁？" + isHeldByCurrentThread());
        System.out.println("锁（对象监视器）是否被其他线程持有？" + isLocked());
    }

}
