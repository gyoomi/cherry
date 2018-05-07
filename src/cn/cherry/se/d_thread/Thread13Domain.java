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
 * @version 2018/5/7 13:56
 */
public class Thread13Domain {

    private int num = 0;

    public synchronized void addNum(String username){
        try {
            if ("a".equals(username)){
                num = 100;
                System.out.println("a set num!!!");
                Thread.sleep(2000);
            } else {
                num = 200;
                System.out.println("b set num!!!");
            }
            System.out.println(username + " num = " + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
