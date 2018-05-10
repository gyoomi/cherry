/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_threadgroup;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/5/10 12:00
 */
public class ThreadGroupAutomatic {

    public static void main(String[] args) {
        System.out.println("A处线程：" + Thread.currentThread().getName() + ",所属线程组：" + Thread.currentThread().getThreadGroup().getName() + ",组中线程组数量是：" + Thread.currentThread().getThreadGroup().activeGroupCount());
        ThreadGroup tg = new ThreadGroup("新建线程组");
        System.out.println("B处线程：" + Thread.currentThread().getName() + ",所属线程组：" + Thread.currentThread().getThreadGroup().getName() + ",组中线程组数量是：" + Thread.currentThread().getThreadGroup().activeGroupCount());
    }
}
