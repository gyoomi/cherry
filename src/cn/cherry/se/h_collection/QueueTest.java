/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.h_collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/5/3 16:26
 */
public class QueueTest {

    public static void main(String[] args) {
        QueueTest.test01();
    }

    public static void test01(){
        Queue<Integer> queue = new LinkedList<>();
        Random random = new Random(100);
        for (int i = 0; i < 20; i++) {
            queue.add(random.nextInt(100));
        }
        System.out.println(queue);
        System.out.println("------------------------------------");
        // 将元素插到尾部
        boolean offer1 = queue.offer(100);
        boolean offer2 = queue.offer(91);
        System.out.println(offer1);
        System.out.println(offer2);
        System.out.println(queue);
        System.out.println("------------------------------------");
        // 返回队头
        Integer element = queue.element();
        Integer peek = queue.peek();
        System.out.println(element);
        System.out.println(peek);
        System.out.println("------------------------------------");
        // 移除并返回队头，当queue为null时，poll则返回null，remove则报错
        Integer poll = queue.poll();
        Integer remove = queue.remove();
    }
}
