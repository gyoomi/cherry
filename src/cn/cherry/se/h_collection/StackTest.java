/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.h_collection;

import java.util.LinkedList;

/**
 * Stack
 *     1、后进先出的容器
 *     2、LinkedList可以实现“栈”的所有功能
 *
 *
 * @author Leon
 * @version 2018/5/3 14:40
 */
public class StackTest {

    public static void main(String[] args) {

    }

    public class Stack<T> {
        private LinkedList<T> storage = new LinkedList<T>();

        public void push(T t){
            storage.addFirst(t);
        }

        public T pop(){
            return storage.removeFirst();
        }

        public T peek(){
            return storage.getFirst();
        }

        public boolean empty(){
            return storage.isEmpty();
        }

        @Override
        public String toString(){
            return storage.toString();
        }
    }
}
