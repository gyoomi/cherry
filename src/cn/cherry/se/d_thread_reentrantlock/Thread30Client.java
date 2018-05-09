/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_reentrantlock;

/**
 * ReentrantLock具有加锁的功能
 *
 * @author Leon
 * @version 2018/5/9 10:41
 */
public class Thread30Client {

    public static void main(String[] args) {
        Thread30Domain td = new Thread30Domain();
        Thread30_00 t3000 = new Thread30_00(td);
        Thread30_00 t3001 = new Thread30_00(td);
        Thread30_00 t3002 = new Thread30_00(td);
        t3000.start();
        t3001.start();
        t3002.start();
    }
}
