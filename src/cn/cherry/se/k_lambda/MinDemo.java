/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.k_lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/8/1 14:47
 */
public class MinDemo {

    public static void main(String[] args) {
        int[] nums = {12, 44, 535, -2343, 43, 34};
        List<Integer> list = new ArrayList<>();
        OptionalInt max = IntStream.of(nums).parallel().max();
        System.out.println(max.getAsInt());
    }
}
