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
 * @version 2018/5/7 15:29
 */
public class Thread15_00 extends Thread {

    @Override
    public void run() {
        Thread15Domain td = new Thread15Domain();
        td.print1();
    }
}
