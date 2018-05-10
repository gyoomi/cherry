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
 * @version 2018/5/10 11:44
 */
public class Thread44_00 extends Thread {

    @Override
    public void run() {
        try {
            for (;;) {
                if (!Thread.currentThread().isInterrupted()) {
                    System.out.println("ThreadName：" + Thread.currentThread().getName());
                    Thread.sleep(2000);
                }
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
