/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.h_collection;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * ListIterator
 *
 * @author Leon
 * @version 2018/5/3 13:59
 */
public class ListIteratorTest {
    /**
     * 1、相比Iterator，可以双向移动
     * 2、listIterator(n)，指向一个索引为n的list
     */
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");
        list.add("555");
        list.add("666");
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
    }
}
