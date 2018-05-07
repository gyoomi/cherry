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
 * @version 2018/5/7 14:09
 */
public class Client13 {

    /**
     * 这里有一个重要的概念。关键字synchronized取得的锁都是对象锁，而不是把一段代码或方法（函数）当作锁，哪个线程先执行带synchronized关键字的方法，哪个线程就持有该方法所属对象的锁，
     * 其他线程都只能呈等待状态。但是这有个前提：既然锁叫做对象锁，那么势必和对象相关，所以多个线程访问的必须是同一个对象。
     *
     * 如果多个线程访问的是多个对象，那么Java虚拟机就会创建多个锁，就像上面的例子一样，创建了两个ThreadDomain13对象，就产生了2个锁。
     * 既然两个线程持有的是不同的锁，自然不会受到"等待释放锁"这一行为的制约，可以分别运行addNum(String userName)中的代码。
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        Thread13Domain td1 = new Thread13Domain();
        Thread13Domain td2 = new Thread13Domain();
        Thread13_00 t1300 = new Thread13_00(td1);
        Thread13_01 t1301 = new Thread13_01(td2);
        t1300.start();
        t1301.start();
    }
}
