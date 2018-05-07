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
 * @version 2018/5/7 16:44
 */
public class Thread18Domain {

    public void methodA(){
        synchronized (this) {
            try {
                System.out.println("methodA startTime = " + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("methodA endTime = " + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void methodB(){
        synchronized (this) {
            try {
                System.out.println("methodB startTime = " + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("methodB endTime = " + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
