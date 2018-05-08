/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_volatile;

/**
 * 原子操作表示一段操作是不可分割的，没有其他线程能够中断或检查正在原子操作中的变量。一个原子类就是一个原子操作可用的类，它可以在没有锁的情况下保证线程安全
 *
 * @author Leon
 * @version 2018/5/8 11:36
 */
public class Thread23Client {

    public static void main(String[] args) {
        try {
            Thread23Domain td = new Thread23Domain();
            Thread23_00[] mt = new Thread23_00[5];
            for (int i = 0; i < mt.length; i++) {
                mt[i] = new Thread23_00(td);
            }
            for (int i = 0; i < mt.length; i++) {
                mt[i].start();
            }
            Thread.sleep(1000);
            System.out.println(Thread23Domain.ai.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
