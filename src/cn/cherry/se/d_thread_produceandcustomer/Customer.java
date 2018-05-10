/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_produceandcustomer;

/**
 * 消费者类似，如果缓冲区是空的，那么就不再消费，wait()等待，等待生产者生产完通知；如果缓冲区不是空的，那么就去拿数据
 *
 * @author Leon
 * @version 2018/5/9 17:37
 */
public class Customer {

    private Object lock;

    public Customer(Object lock) {
        this.lock = lock;
    }

    public void getValue() {
        try {
            synchronized (lock) {
                if (ValueObject.value.equals("")) {
                    System.out.println("消费者：" + Thread.currentThread().getName() + " waiting ☆");
                    lock.wait();
                } else {
                    System.out.println("消费者：" + Thread.currentThread().getName() + " runnable...");
                    System.out.println("getValue: " + ValueObject.value);
                    ValueObject.value = "";
                    lock.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
