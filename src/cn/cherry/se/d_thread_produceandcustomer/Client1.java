/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_produceandcustomer;

/**
 * 生产数据和消费数据一定是成对出现的，生产一个消费一个，满了不生产，空了不消费，生产者不能无限生产，消费者也不能无限消费，符合生产者/消费者模型。
 * 生产者速度快，就不占用CPU时间片，等着消费者消费完通知它继续生产，这块时间片可以用来给其他线程用。
 *
 * 一对一的生产消费模式 -> 多对多的生产者和消费者模式
 *
 * @author Leon
 * @version 2018/5/9 17:40
 */
public class Client1 {

    public static void main(String[] args) {
        Object lock = new Object();
        final Producer producer = new Producer(lock);
        final Customer customer = new Customer(lock);
        Runnable rn1 = () -> {
            while (true){
                producer.setValue();
            }
        };
        Runnable rn2 = () -> {
            while (true){
                customer.getValue();
            }
        };

        Thread t0 = new Thread(rn1);
        t0.setName("生产者 1");
        Thread t1 = new Thread(rn1);
        t1.setName("生产者 2");
        Thread t2 = new Thread(rn2);
        t2.setName("消费者 1");
        Thread t3 = new Thread(rn2);
        t3.setName("消费者 2");
        t0.start();
        t1.start();
        t2.start();
        t3.start();
    }
}
