/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.k_lambda;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/8/1 14:12
 */
public class ThreadDemo {

    public static void main(String[] args) {
        Object target = new Runnable() {
            @Override
            public void run() {
                System.out.println("ok");
            }
        };
        new Thread((Runnable) target).start();
        Runnable r2 = () -> {
            System.out.println("r2 not ok");
        };
        Runnable r3 = () -> {
            System.out.println("r3 not ok");
        };
        System.out.println(r2 == r3);
    }
}
