/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_reentrantlock;

/**
 * ReentrantLock有一个很大的特点，就是可以指定锁是公平锁还是非公平锁
 * new ReentrantLock的时候有一个单一参数的构造函数表示构造的是一个公平锁还是非公平锁，传入true就可以了
 *
 * @author Leon
 * @version 2018/5/9 13:38
 */
public class Thread33Client {

    public static void main(String[] args) {
        Thread33Domain td = new Thread33Domain();
        Runnable rn  = new Runnable(){
            @Override
            public void run() {
                System.out.println("※" + Thread.currentThread().getName() + "运行了");
                td.testMethod();
            }
        };

        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(rn);
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }
}
