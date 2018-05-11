/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_othercomponent;

import java.util.concurrent.Semaphore;

/**
 * Semaphore是非常有用的一个组件，它相当于是一个并发控制器，是用于管理信号量的。构造的时候传入可供管理的信号量的数值，这个数值就是控制并发数量的，我们需要控制并发的代码，执行前先通过acquire方法获取信号，执行后通过release归还信号 。每次acquire返回成功后，Semaphore可用的信号量就会减少一个，如果没有可用的信号，acquire调用就会阻塞，等待有release调用释放信号后，acquire才会得到信号并返回。
 *
 * Semaphore分为单值和多值两种：
 *
 * 1、单值的Semaphore管理的信号量只有1个，该信号量只能被1个，只能被一个线程所获得，意味着并发的代码只能被一个线程运行，这就相当于是一个互斥锁了
 * 2、多值的Semaphore管理的信号量多余1个，主要用于控制并发数
 *
 * @author Leon
 * @version 2018/5/11 10:40
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        Runnable rn1 = new Runnable() {
            @Override
            public void run() {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() +" 获得了信号， Time = " + System.currentTimeMillis());
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() +" 释放了信号， Time = " + System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }
        };

        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(rn1);
        }
        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
    }

    /**
     *
     * 前10行为一部分，运行的线程是1 2 0 3 4，看到时间差也都是代码约定的2秒；后10行为一部分，运行的线程是9 7 6 5 8，时间差也都是约定的2秒，这就体现出了Semaphore的作用了。
     *
     * 这种通过Semaphore控制并发并发数的方式和通过控制线程数来控制并发数的方式相比，粒度更小，因为Semaphore可以通过acquire方法和release方法来控制代码块的并发数。
     *
     * 最后注意两点：
     * 1、Semaphore可以指定公平锁还是非公平锁
     * 2、acquire方法和release方法是可以有参数的，表示获取/返还的信号量个数
     *
     *
     */
}
