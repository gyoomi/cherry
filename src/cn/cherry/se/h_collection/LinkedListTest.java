/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.h_collection;

import java.util.LinkedList;

/**
 * LinkedList
 *
 * @author Leon
 * @version 2018/5/3 14:10
 */
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedListTest.test01();
    }

    /**
     * 1、查询性能差于ArrayList，但是删除和修改好于其
     * 2、提供了额外的方法，见下面测试
     * 3、peek()方法区别在于list为null时，peek返回null，则其他的报错(NoSuchElementException)
     */
    public static void test01(){
        LinkedList<String> list = new LinkedList<>();
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");
        list.add("555");
        list.add("666");
        list.add("777");
        list.add("888");
        list.add("999");
        String first = list.getFirst();
        String last = list.getLast();
        System.out.println(first);
        System.out.println(last);
        System.out.println("-------------------------");
        list.addFirst("101010");
        list.addLast("111111");
        System.out.println(list);
        System.out.println("-------------------------");
        // 和getFirst()一样的作用
        String element = list.element();
        String peek = list.peek();
        String peekFirst = list.peekFirst();
        String peekLast = list.peekLast();
        System.out.println(element);
        System.out.println(peek);
        System.out.println(peekFirst);
        System.out.println(peekLast);
        System.out.println("-------------------------");
        // 移除最后元素(随后将删除)，并返回列表最后一个元素
        String removeLast = list.removeLast();
        System.out.println(removeLast);
        System.out.println(list);
    }
}
