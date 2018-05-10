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
 * @version 2018/5/10 13:58
 */
public class Thread45Domain extends Thread {

    public Thread45Domain(ThreadGroup group, String name) {
        super(group, name);
    }

    @Override
    public void run() {
        System.out.println("准备开始死循环：ThreadName = " + Thread.currentThread().getName());
        while (!this.isInterrupted()) {}
        System.out.println("结束了：ThreadName = " + Thread.currentThread().getName());
    }
}
