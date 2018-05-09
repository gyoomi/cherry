/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_threadlocal;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/5/8 17:25
 */
public class Client {

    public static void main(String[] args) {
        ThreadLocalThread local1 = new ThreadLocalThread("Thread 1");
        ThreadLocalThread local2 = new ThreadLocalThread("Thread 2");
        ThreadLocalThread local3 = new ThreadLocalThread("Thread 3");
        local1.start();
        local2.start();
        //local3.start();
    }
}
