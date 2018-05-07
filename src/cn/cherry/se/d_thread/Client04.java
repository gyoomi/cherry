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
 * @version 2018/5/7 9:50
 */
public class Client04 {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getId() + ":" + Thread.currentThread().getName() + "--->" + Thread.currentThread().getPriority());
        Thread04_00 t0400 = new Thread04_00();
        Thread04_01 t0401 = new Thread04_01();
        t0400.start();
        t0401.start();
    }
}
