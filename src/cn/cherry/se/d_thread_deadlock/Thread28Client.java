/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_deadlock;

/**
 * interrupt()方法的作用不是中断线程，而是在线程阻塞的时候给线程一个中断标识，表示该线程中断。wait()就是"阻塞的一种场景"，看一下用interrupt()打断wait()的例子
 *
 * @author Leon
 * @version 2018/5/8 15:49
 */
public class Thread28Client {

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread28_00 t2800 = new Thread28_00(lock);
        t2800.start();
        Thread.sleep(5000);
        t2800.interrupt();
    }
}
