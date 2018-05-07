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
 * @version 2018/5/7 10:28
 */
public class Client08 {

    /**
     * 1.join()方法会使调用join()方法的线程（也就是mt线程）所在的线程（也就是main线程）无限阻塞，
     * 直到调用join()方法的线程销毁为止，
     *
     * 2.join()方法的一个重点是要区分出和sleep()方法的区别。join(2000)也是可以的，表示调用join()方法所在的线程最多等待2000ms，
     * 两者的区别在于：
     *     sleep(2000)不释放锁，join(2000)释放锁，因为join()方法内部使用的是wait()，因此会释放锁。
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Thread08_00 t0800 = new Thread08_00();
        t0800.start();
        t0800.join();
        System.out.println("我想等t0800对象执行完毕再执行我自己。");
    }
}
