/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_reentrantreadwritelock;

/**
 * 证明了读和写之间是互斥的。注意一下，"读和写互斥"和"写和读互斥"是两种不同的场景，但是证明方式和结论是一致的
 *
 * @author Leon
 * @version 2018/5/9 16:05
 */
public class Thread41Client {

    public static void main(String[] args) {
        Thread41Domain td = new Thread41Domain();
        Runnable readRunnable = new Runnable() {
            @Override
            public void run() {
                td.read();
            }
        };
        Runnable writeRunnable = new Runnable() {
            @Override
            public void run() {
                td.write();
            }
        };

        Thread t0 = new Thread(readRunnable);
        Thread t1 = new Thread(writeRunnable);
        t0.start();
        t1.start();
    }
}
