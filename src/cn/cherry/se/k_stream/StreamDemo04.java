/**
 * Copyright © 2018, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.k_stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/8/5 14:55
 */
public class StreamDemo04 {

    public static void main(String[] args) {
        String str = "My name is 007";
        // 把每个单词的长度调出来
        Stream.of(str.split(" ")).filter(s -> s.length() > 2).map(s -> s.length()).forEach(System.out::println);
        System.out.println("----------------");
        // flatMap A->B属性(是个集合), 最终得到所有的A元素里面的所有B属性集合
        // intStream/longStream 并不是Stream的子类, 所以要进行装箱 boxed
        Stream.of(str.split(" ")).flatMap(s -> s.chars().boxed()).forEach(s -> System.out.println((char) s.intValue()));
        System.out.println("-------peek-----------");
        // peek用于debug,是个一个中间操作，foreach是一个终止操作
        Stream.of(str.split(" ")).peek(s -> System.out.println(s)).forEach(System.out::println);
        // limit主要用于无限流
        System.out.println("--------limit------------");
        new Random().ints().filter(i -> i > 100 && i <1000).limit(6).forEach(System.out::println);
        // reduce的使用，主要用于聚合
        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        Integer totalSum = ints.stream().reduce((sum, item) -> sum + item).get();
        System.out.println("计算求和为： " + totalSum);
        // allMatch -> 是不是Stream中的所有元素都满足给定的匹配条件
        // anyMatch -> Stream中是否存在任何一个元素满足匹配条件
        // findFirst -> 返回Stream中的第一个元素，如果Stream为空，返回空Optional
        // noneMatch -> 是不是Stream中的所有元素都不满足给定的匹配条件
        // ax和min -> 使用给定的比较器（Operator），返回Stream中的最大|最小值
        System.out.println("------allMatch-----");
        List<Integer> ints2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        System.out.println(ints2.stream().allMatch(item -> item > 10));
        System.out.println(ints2.stream().anyMatch(item -> item > 10));
        System.out.println("最大值是： " + ints2.stream().max((x1, x2) -> x2 - x1).get());
    }
}
