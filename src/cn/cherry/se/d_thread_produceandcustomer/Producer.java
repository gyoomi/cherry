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
                if (!ValueObject.value.equals("")){
                    lock.wait();
                    String value = System.currentTimeMillis() + "";
                    System.out.println("setValue的值是：" + value);
                    ValueObject.value = value;
                    lock.notify();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
