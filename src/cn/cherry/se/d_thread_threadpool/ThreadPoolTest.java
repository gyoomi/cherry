/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_threadpool;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/5/10 14:41
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        doItByPool();
    }


    public static void doItOneByOne() {
        long startTime = System.currentTimeMillis();
        LinkedList<Integer> list = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < 20000; i++) {
            Thread t = new Thread(){
                @Override
                public void run() {
                   list.add(random.nextInt());
                }
            };
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("用时：" + (System.currentTimeMillis() - startTime) + " 毫秒");
        System.out.println("集合容量为：" + list.size());
    }

    public static void doItByPool() {
        long startTime = System.currentTimeMillis();
        LinkedList<Integer> list = new LinkedList<>();
        Random random = new Random();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(100, 100, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<>(20000));
        for (int i = 0; i < 20000; i++) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    list.add(random.nextInt());
                }
            });
        }
        pool.shutdown();
        try {
            pool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("用时：" + (System.currentTimeMillis() - startTime) + " 毫秒");
        System.out.println("集合容量为：" + list.size());
    }

}
