/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_volatile;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/5/8 11:27
 */
public class Thread23Domain {

    public static AtomicInteger ai = new AtomicInteger();

    public synchronized void addNum() {
        System.out.println(Thread.currentThread().getName() + " 加了100后的结果：" + ai.addAndGet(100));
        ai.getAndAdd(1);
    }
}
