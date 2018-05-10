/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_threadgroup;

/**
 * 根线程组
 * 1、根线程组就是系统线程组system
 * 2、抛空指针异常是因为系统线程组上已经没有线程组了，所以system的getParent()方法返回的是null，对null调用getName()方法自然是NullPointerException
 *
 * @author Leon
 * @version 2018/5/10 13:46
 */
public class ThreadGroupRoot {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getThreadGroup().getName());
        System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
        System.out.println(Thread.currentThread().getThreadGroup().getParent().getParent().getName());
    }
}
