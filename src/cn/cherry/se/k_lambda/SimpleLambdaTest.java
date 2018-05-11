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
 * @version 2018/5/4 17:41
 */
public class SimpleLambdaTest {
    public static void main(String[] args) {
        test01();
    }

    /**
     * show anonymous function how to use
     *
     */
    public static void test01() {
        Runnable r1 = () -> System.out.println("hello lambda");
        r1.run();
    }
}
