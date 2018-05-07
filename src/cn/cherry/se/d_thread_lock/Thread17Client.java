/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_lock;

/**
 * 当A线程访问对象的synchronized代码块的时候，B线程依然可以访问对象方法中其余非synchronized块的部分，第一部分的执行结果证明了这一点
 * 当A线程进入对象的synchronized代码块的时候，B线程如果要访问这段synchronized块，那么访问将会被阻塞，第二部分的执行结果证明了这一点
 *
 * @author Leon
 * @version 2018/5/7 15:58
 */
public class Thread17Client {

    public static void main(String[] args) {
        Thread17Domain td = new Thread17Domain();
        Thread17_00 t1700 = new Thread17_00(td);
        Thread17_00 t1701= new Thread17_00(td);
        t1700.start();
        t1701.start();
    }
}
