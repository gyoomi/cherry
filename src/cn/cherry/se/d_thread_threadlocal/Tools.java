/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_threadlocal;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/5/8 17:11
 */
public class Tools {

    public static ThreadLocal<String> t = new ThreadLocal<>();





    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger();
        ai.addAndGet(11);
        ai.getAndAdd(112);
        System.out.println(ai.get());
    }
}
