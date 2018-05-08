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
 * @version 2018/5/8 9:56
 */
public class Thread21Domain {

    public synchronized static void printA(){
        try {
            System.out.println("线程名字：" + Thread.currentThread().getName() + " 在" + System.currentTimeMillis() + " 进入printA() ");
            Thread.sleep(2000);
            System.out.println("线程名字：" + Thread.currentThread().getName() + " 在" + System.currentTimeMillis() + " 离开printA() ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized static void printB() {
        System.out.println("线程名字：" + Thread.currentThread().getName() + " 在" + System.currentTimeMillis() + " 进入printB() ");
        System.out.println("线程名字：" + Thread.currentThread().getName() + " 在" + System.currentTimeMillis() + " 离开printB() ");
    }

    public synchronized void printC() {
        System.out.println("线程名字：" + Thread.currentThread().getName() + " 在" + System.currentTimeMillis() + " 进入printC() ");
        System.out.println("线程名字：" + Thread.currentThread().getName() + " 在" + System.currentTimeMillis() + " 离开printC() ");
    }
}
