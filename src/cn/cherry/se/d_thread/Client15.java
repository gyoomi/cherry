/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread;

/**
 * synchronized锁重入
 * 关键字synchronized拥有锁重入的功能。所谓锁重入的意思就是：当一个线程得到一个对象锁后，再次请求此对象锁时时可以再次得到该对象的锁的。
 * 证明了对象可以再次获取自己的内部锁。这种锁重入的机制，也支持在父子类继承的环境中。
 *
 * @author Leon
 * @version 2018/5/7 15:29
 */
public class Client15 {

    public static void main(String[] args) {
        Thread15_00 t1500 = new Thread15_00();
        t1500.start();
    }
}
