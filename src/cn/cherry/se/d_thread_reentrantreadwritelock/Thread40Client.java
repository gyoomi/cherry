/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_reentrantreadwritelock;

/**
 * 写和写之间互斥
 *
 * @author Leon
 * @version 2018/5/9 15:24
 */
public class Thread40Client {

    public static void main(String[] args) {
        Thread40Domain td = new Thread40Domain();
        Runnable rn1 = new Runnable() {
            @Override
            public void run() {
                td.write();
            }
        };
        Thread t0 = new Thread(rn1);
        Thread t1 = new Thread(rn1);
        t0.start();
        t1.start();
    }
}
