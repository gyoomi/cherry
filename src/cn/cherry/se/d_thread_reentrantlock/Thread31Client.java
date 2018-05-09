/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_reentrantlock;

/**
 * 1.ReentrantLock持有的是"对象监视器";
 * 2.ReentrantLock和synchronized持有的对象监视器不同;
 * 3.ReentrantLock持有的锁是需要手动去unlock()的.
 *
 * @author Leon
 * @version 2018/5/9 11:17
 */
public class Thread31Client {

    public static void main(String[] args) {
        Thread31Domain td = new Thread31Domain();
        Thread31_00  t3100 = new Thread31_00(td);
        Thread31_01  t3101 = new Thread31_01(td);
        t3101.start();
        t3100.start();
    }
}
