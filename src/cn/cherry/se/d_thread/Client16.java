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
 * @version 2018/5/7 15:44
 */
public class Client16 {

    public static void main(String[] args) {
        Thread16Domain td = new Thread16Domain();
        Thread16_00 t1600 = new Thread16_00(td);
        Thread16_00 t1601 = new Thread16_00(td);
        t1600.start();
        t1601.start();
    }
}
