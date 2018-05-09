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
 * @version 2018/5/8 17:21
 */
public class ThreadLocalThread extends Thread {

    private static AtomicInteger ai = new AtomicInteger();

    public ThreadLocalThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 3; i++) {
                Tools.t.set(ai.addAndGet(1) + "");
                System.out.println(this.getName() + " get value--->" + Tools.t.get());
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
