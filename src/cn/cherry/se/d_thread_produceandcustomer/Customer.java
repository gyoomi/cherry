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
                if (ValueObject.value.equals("")){
                    lock.wait();
                    System.out.println("getValue: " + ValueObject.value);
                    ValueObject.value = "";
                    lock.notify();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
