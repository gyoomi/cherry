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
 * @version 2018/5/7 10:09
 */
public class Client06 {

    public static void main(String[] args) throws Exception{
        Thread06_00 t0600 = new Thread06_00();
        t0600.setDaemon(true);
        t0600.start();
        Thread.sleep(5000);
        System.out.println("看到我，就不再打印了...");

        /**
         * output:
         *
         * 1
         * 2
         * 3
         * 4
         * 5
         * 看到我，就不再打印了...
         */
    }
}
