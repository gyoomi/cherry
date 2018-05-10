/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_blockqueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/5/10 11:16
 */
public class BlockQueueTest {

    public static void main(String[] args) {
        ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<>(10);

       Runnable rn1 = new Runnable(){
           int i = 0;

           @Override
           public void run() {
               for (;;) {
                   try {
                       System.out.println("生产了一个：" + i);
                       abq.put(String.valueOf(i));
                       i++;
                       Thread.sleep(200);
                   } catch (InterruptedException e){
                       e.printStackTrace();
                   }
               }

           }
       };

        Runnable rn2 = new Runnable(){
            @Override
            public void run() {
                for (;;) {
                    try {
                        System.out.println("消费前：" + abq);
                        System.out.println("消费了一个：" + abq.take());
                        System.out.println("消费后：" + abq);
                        Thread.sleep(200);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }

            }
        };

        Thread t0 = new Thread(rn1);
        Thread t1 = new Thread(rn2);
        t0.start();
        t1.start();
    }
}
