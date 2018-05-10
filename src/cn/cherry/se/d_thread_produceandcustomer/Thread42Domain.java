/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_produceandcustomer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/5/10 9:36
 */
public class Thread42Domain {

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void setValue() {
        try {
            lock.lock();
            if (!("").equals(ValueObject.value)) {
                condition.await();
            } else {
                String value = ((Math.random() * 100000000) + "").substring(0, 8);
                System.out.println("setValue的值是：" + value);
                ValueObject.value = value;
                condition.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void getValue() {
        try {
            lock.lock();
            if (("").equals(ValueObject.value)) {
                condition.await();
            } else {
                System.out.println("getValue: " + ValueObject.value);
                ValueObject.value = "";
                condition.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
