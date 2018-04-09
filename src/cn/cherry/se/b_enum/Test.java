/**
 * Copyright © 2018, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.b_enum;

import java.util.EnumMap;
import java.util.EnumSet;

/**
 * Enum测试类
 *
 * @author Leon
 * @version 2018/4/9 22:36
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        t.test03();
    }

    /**
     * 枚举的基本用法
     *
     */
    public void test01(){
        WeekEnum monday = WeekEnum.MONDAY;
        System.out.println(monday.getName() + ":" + monday.getValue());
    }

    /**
     *EnumSet的基本用法
     *
     */
    public void test02(){
        EnumSet<WeekEnum> weekEnums = EnumSet.allOf(WeekEnum.class);
        weekEnums.forEach(System.out::println);
        System.out.println("-------------------");
        weekEnums.forEach((week) -> {
            System.out.println(week + "-> [" + week.getName() + ":" + week.getValue()  +"]");
        });
    }

    /**
     * EnumMap的使用
     *
     */
    public void test03(){
        EnumMap<WeekEnum,String> map = new EnumMap<>(WeekEnum.class);
        map.put(WeekEnum.MONDAY, "foo");
        map.put(WeekEnum.TUESDAY, "bar");
        map.put(WeekEnum.WENSDAY, "fbr");
        map.forEach((k,v) -> {
            System.out.println(k + ":" + v);
        });
    }
}
