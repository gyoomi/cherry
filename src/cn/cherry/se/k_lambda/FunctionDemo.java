/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.k_lambda;

import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/8/2 16:14
 */
public class FunctionDemo {

    public static void main(String[] args) {
        // 断言函数
        Predicate<Integer> predicate1 = x -> x > 10;
        Predicate<Integer> predicate2 = x -> x < 20;
        System.out.println(predicate1.and(predicate2).test(22));
        // 消费函数
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("hello lambda!!!");
    }
}
