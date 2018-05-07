/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/5/7 14:36
 */
public class Thread14_00Domain {

    public synchronized void methodA(){
        try {
            System.out.println("methodA Start... ThreadName = " + Thread.currentThread().getName());
            Thread.sleep(4_000);
            System.out.println("methodA End... ThreadName = " + Thread.currentThread().getName() + " endTime = " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void methodB(){
        try {
            System.out.println("methodB Start... ThreadName = " + Thread.currentThread().getName());
            Thread.sleep(4_000);
            System.out.println("methodB End... ThreadName = " + Thread.currentThread().getName() + " endTime = " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
