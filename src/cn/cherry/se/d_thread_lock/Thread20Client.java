/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_lock;

/**
 * 1.多个线程持有"对象监视器"为同一个对象的前提下，同一时间只能有一个线程可以执行synchronized(非this对象x)代码块中的代码。
 * 2.锁非this对象具有一定的优点：如果在一个类中有很多synchronized方法，这时虽然能实现同步，但会受到阻塞，从而影响效率。但如果同步代码块锁的是非this对象，
 *   则synchronized(非this对象x)代码块中的程序与同步方法是异步的，不与其他锁this同步方法争抢this锁，大大提高了运行效率。
 * 3.synchronized(非this对象x)，这个对象如果是实例变量的话，指的是对象的引用，只要对象的引用不变，即使改变了对象的属性，运行结果依然是同步的。
 *
 * @author Leon
 * @version 2018/5/8 9:20
 */
public class Thread20Client {

    public static void main(String[] args) {
        Thread20Domain td = new Thread20Domain();
        Thread20_00 t2000 = new Thread20_00(td);
        Thread20_01 t2001 = new Thread20_01(td);
        t2000.start();
        t2001.start();

    }
}
