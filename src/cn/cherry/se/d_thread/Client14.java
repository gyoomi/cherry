/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/5/7 14:43
 */
public class Client14 {
    /**
     * A线程持有Object对象的Lock锁，B线程可以以异步方式调用Object对象中的非synchronized类型的方法
     * A线程持有Object对象的Lock锁，B线程如果在这时调用Object对象中的synchronized类型的方法则需要等待，也就是同步
     * @param args
     */
    public static void main(String[] args) {
        Thread14_00Domain td = new Thread14_00Domain();
        Thread14_00 t1400 = new Thread14_00(td);
        Thread14_01 t1401 = new Thread14_01(td);
        t1400.start();
        t1401.start();
    }
}
