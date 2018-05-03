/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.h_collection;

import java.util.Collections;
import java.util.HashSet;

/**
 * Set
 *     1、不保存重复的元素
 *     2、HashSet专门对查找进行优化，TreeSet把数据存储于红黑数的结构中，并对结果进行排序后添加
 *
 * @author Leon
 * @version 2018/5/3 14:54
 */
public class SetTest {

    public static void main(String[] args) {
        SetTest.test01();
    }

    public static void test01(){
        HashSet<String> set = new HashSet();
        Collections.addAll(set, "A B C D E F G".split(","));
        System.out.println(set);
        System.out.println("-----------------------");
    }

}
