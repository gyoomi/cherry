/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_produceandcustomer;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/5/9 17:40
 */
public class Client1 {

    public static void main(String[] args) {
        Object lock = new Object();
        Producer producer = new Producer(lock);
        Customer customer = new Customer(lock);
        Runnable rn1 = () -> {
            for (;;){
                producer.setValue();
            }
        };
        Runnable rn2 = () -> {
            for (;;){
                customer.getValue();
            }
        };

        Thread t0 = new Thread(rn1);
        Thread t1 = new Thread(rn2);
        t0.start();
        t1.start();
    }
}
