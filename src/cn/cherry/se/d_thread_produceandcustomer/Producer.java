/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_produceandcustomer;

/**
 * 生产者了，如果缓冲区满了的，那么就wait()，不再生产了，等待消费者消费完通知；如果缓冲区是空的，那么就生产数据到缓冲区中
 *
 * @author Leon
 * @version 2018/5/9 17:31
 */
public class Producer {

    private Object lock;

    public Producer(Object lock) {
        this.lock = lock;
    }

    public void setValue() {
        try {
            synchronized (lock) {
                if (!ValueObject.value.equals("")) {
                    System.out.println("生产者：" + Thread.currentThread().getName() + " waiting ★");
                    lock.wait();
                } else {
                    System.out.println("生产者：" + Thread.currentThread().getName() + " runnable...");
                    String value = ((Math.random() * 100000000) + "").substring(0, 8);
                    System.out.println("setValue的值是：" + value);
                    ValueObject.value = value;
                    lock.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
