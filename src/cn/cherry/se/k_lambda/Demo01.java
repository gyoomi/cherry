/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.k_lambda;

import java.util.function.Consumer;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/7/31 17:05
 */
public class Demo01 {

    public static void main(String[] args) {
        Consumer<Integer> consumer1 = x -> {
            int num = x * 1;
            System.out.println(num);
        };

        Consumer<Integer> consumer2 = x -> {
            int num = x * 2;
            System.out.println(num);
        };

        Consumer<Integer> consumer3= x -> {
            int num = x * 3;
            System.out.println(num);
        };
        consumer1.andThen(consumer2).andThen(consumer3).accept(10);
    }
}
