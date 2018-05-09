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
 * @version 2018/5/9 14:43
 */
public class Thread38Domain extends ReentrantLock {

    public void testMethod() {
        if (tryLock()) {
            System.out.println(Thread.currentThread().getName() + "获得了锁");
        } else {
            System.out.println(Thread.currentThread().getName() + "没有获得了锁");
        }
    }
}
