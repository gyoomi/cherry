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
 * @version 2018/5/9 13:49
 */
public class Thread34Domain {

    private ReentrantLock lock = new ReentrantLock();

    public void method1() {
        lock.lock();
        System.out.println("method1 Start...holdCount = " + lock.getHoldCount());
        method2();
        lock.unlock();
    }

    public void method2() {
        lock.lock();
        System.out.println("method2 Start...holdCount = " + lock.getHoldCount());
        method3();
        lock.unlock();
    }

    public void method3() {
        lock.lock();
        System.out.println("method3 Start...holdCount = " + lock.getHoldCount());
        lock.unlock();
    }
}
