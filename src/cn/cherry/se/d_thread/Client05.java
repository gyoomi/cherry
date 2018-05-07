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
 * @version 2018/5/7 9:58
 */
public class Client05 {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread05_00 t0500 = new Thread05_00();
            Thread05_01 t0501 = new Thread05_01();
            t0500.setPriority(7);
            t0500.start();
            t0501.start();
        }
    }
}
