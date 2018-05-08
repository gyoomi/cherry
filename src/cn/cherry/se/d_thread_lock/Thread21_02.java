/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_lock;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/5/8 10:05
 */
public class Thread21_02 extends Thread {

    @Override
    public void run() {
        Thread21Domain.printB();
    }
}
