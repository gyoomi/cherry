/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.k_lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * 变量引用
 *
 * @author Leon
 * @version 2018/8/1 11:14
 */
public class VarDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Consumer<String> c = s -> System.out.println(s + list);
        c.accept("123123");
    }
}
