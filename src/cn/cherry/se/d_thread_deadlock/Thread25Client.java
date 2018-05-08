/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_deadlock;

/**
 * 1.wait()方法可以使调用该线程的方法释放共享资源的锁，然后从运行状态退出，进入等待队列，直到再次被唤醒。
 * 2.notify()方法可以随机唤醒等待队列中等待同一共享资源的一个线程，并使得该线程退出等待状态，进入可运行状态
 * 3.notifyAll()方法可以使所有正在等待队列中等待同一共享资源的全部线程从等待状态退出，进入可运行状态
 * 4.最后，如果wait()方法和notify()/notifyAll()方法不在同步方法/同步代码块中被调用，那么虚拟机会抛出java.lang.IllegalMonitorStateException，注意一下。
 *
 * @author Leon
 * @version 2018/5/8 14:47
 */
public class Thread25Client {

    public static void main(String[] args) throws Exception{
        Object lock = new Object();
        Thread25_00 t2500 = new Thread25_00(lock);
        Thread25_01 t2501 = new Thread25_01(lock);
        t2500.start();
        Thread.sleep(3000);
        t2501.start();
    }
}
