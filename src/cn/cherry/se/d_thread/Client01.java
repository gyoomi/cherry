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
 * @version 2018/4/25 17:04
 */
public class Client01 {
    public static void main(String[] args) {
        Thread01_00 t1 = new Thread01_00();
        t1.start();
        Thread02_00 t2 = new Thread02_00();
        Thread t001  = new Thread(t2);
        t001.start();
    }
}
