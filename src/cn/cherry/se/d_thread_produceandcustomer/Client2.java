/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_produceandcustomer;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/5/10 9:58
 */
public class Client2 {

    public static void main(String[] args) {
        Thread42Domain td = new Thread42Domain();
        Runnable rn1 = () -> {
          for (;;) {
              td.setValue();
          }
        };

        Runnable rn2 = () -> {
            for (;;) {
                td.getValue();
            }
        };

        Thread t0 = new Thread(rn1);
        Thread t1 = new Thread(rn2);
        t0.start();
        t1.start();
    }
}
