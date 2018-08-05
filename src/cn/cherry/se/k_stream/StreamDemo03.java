/**
 * Copyright © 2018, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.k_stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/8/5 14:50
 */
public class StreamDemo03 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        // 从集合创建流
        list.stream();
        list.parallelStream();
        // 从数组创建流
        Arrays.stream(new int[]{1, 2, 3});
        // 创建数组流
        IntStream.of(1, 2, 3);
        IntStream.rangeClosed(1, 20);
        // 使用random创建一个无限流
        new Random().ints().limit(10);
        // 使用自己产生自己
        Stream.generate(() -> new Random().nextInt()).limit(8).forEach(System.out::println);
    }
}
