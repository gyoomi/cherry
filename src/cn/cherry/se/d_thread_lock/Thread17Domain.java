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
 * @version 2018/5/7 15:52
 */
public class Thread17Domain {

    public void doLongTimeTask() throws Exception{
        for (int i = 0; i < 100; i++) {
            System.out.println("no synchronized block ,ThreadName = " + Thread.currentThread().getName() + " i = " + (i + 1));
        }

        synchronized (this){
            for (int i = 0; i < 100; i++) {
                System.out.println("synchronized block ,ThreadName = " + Thread.currentThread().getName() + " i = " + (i + 1));
            }
        }
    }
}
