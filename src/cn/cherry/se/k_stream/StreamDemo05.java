/**
 * Copyright © 2018, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.k_stream;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/8/5 15:16
 */
public class StreamDemo05 {

    public static void main(String[] args) {
        String str = "my name is 007";

        // 使用并行流,保证输出结果的有序性
        // str.chars().parallel().forEach(i -> System.out.print((char)i));
        str.chars().parallel().forEachOrdered(i -> System.out.print((char)i));
        // 收集到list
        List<String> list = Stream.of(str.split(" "))
                .collect(Collectors.toList());
        // 使用reduce来拼接字符串
        System.out.println("---reduce---");
        System.out.println(Stream.of(str.split(" ")).reduce((s1, s2) -> s1 + "$" + s2).get());
        // 带初始化值的reduce
        String reduce = Stream.of(str.split(" ")).reduce("",
                (s1, s2) -> s1 + "|" + s2);
        System.out.println(reduce);
        // 计算所有 单词的总长度
        System.out.println("---length---");
        int length = Stream.of(str.split(" ")).mapToInt(s -> s.length()).reduce(0, (s1, s2) -> s1 + s2);
        System.out.println(length);
        // max的使用
        Optional<String> max = Stream.of(str.split(" ")).max((s1, s2) -> s1.length() - s2.length());
        System.out.println(max.get());
        long count = Stream.of(str.split(" ")).count();
        System.out.println("count: " + count);
        // findFirst短路操作
        System.out.println("---findFirst---");
        OptionalInt first = new Random().ints().findFirst();
        OptionalInt any = new Random().ints().findAny();
        System.out.println(first.getAsInt());
        System.out.println(any.getAsInt());
    }
}
