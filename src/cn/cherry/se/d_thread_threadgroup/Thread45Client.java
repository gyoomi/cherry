/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_threadgroup;

/**
 * 批量停止组内线程
 * 使用线程组自然是要对线程做批量管理的
 *
 * @author Leon
 * @version 2018/5/10 14:02
 */
public class Thread45Client {

    public static void main(String[] args) throws InterruptedException {
        ThreadGroup tg = new ThreadGroup("我的线程组");
        Thread45Domain td = null;
        for (int i = 0; i < 3; i++) {
            td = new Thread45Domain(tg, "xc" + i);
            td.start();
        }
        Thread.sleep(5000);
        tg.interrupt();
        System.out.println("调用了interrupt方法");
    }
}
