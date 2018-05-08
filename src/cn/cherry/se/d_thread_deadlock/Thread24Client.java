/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_deadlock;

/**
 * 一个类可能发生死锁，并不意味着每次都会发生死锁，这只是表示有可能。当死锁出现时，往往是在最糟糕的情况----高负载的情况下
 *
 *
 * 避免死锁的方式
 * 1、让程序每次至多只能获得一个锁。当然，在多线程环境下，这种情况通常并不现实
 * 2、设计时考虑清楚锁的顺序，尽量减少嵌在的加锁交互数量
 * 3、既然死锁的产生是两个线程无限等待对方持有的锁，那么只要等待时间有个上限不就好了。当然synchronized不具备这个功能，但是我们可以使用Lock类中的tryLock方法去尝试获取锁，这个方法可以指定一个超时时限，在等待超过该时限之后变回返回一个失败信息
 *
 * @author Leon
 * @version 2018/5/8 13:46
 */
public class Thread24Client {

    public static void main(String[] args) {
        Thread24Domain td = new Thread24Domain();
        Thread24_00 t2400 = new Thread24_00(td);
        Thread24_01 t2401 = new Thread24_01(td);
        t2400.start();
        t2401.start();
    }
}
