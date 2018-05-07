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
 * @version 2018/5/7 15:37
 */
public class Thread16Domain {

    public synchronized void testMethod(){
        try {
            System.out.println("Enter Thread testMethod" + Thread.currentThread().getName());
            int value = 5;
            for (;;){
                int rs = 2 / value;
                Thread.sleep(1000);
                value--;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
