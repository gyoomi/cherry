/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_volatile;

/**
 * volatile的作用就是这样，被volatile修饰的变量，保证了每次读取到的都是最新的那个值。线程安全围绕的是可见性和原子性这两个特性展开的，volatile解决的是变量在多个线程之间的可见性，但是无法保证原子性。
 *
 * 多提一句，synchronized除了保障了原子性外，其实也保障了可见性。因为synchronized无论是同步的方法还是同步的代码块，都会先把主内存的数据拷贝到工作内存中，同步代码块结束，会把工作内存中的数据更新到主内存中，这样主内存中的数据一定是最新的
 *
 * @author Leon
 * @version 2018/5/8 10:33
 */
public class Thread22Client {

    public static void main(String[] args) {
        try {
            Thread22_00 t2200 = new Thread22_00();
            t2200.start();
            Thread.sleep(5000);
            t2200.setRunning(false);
            System.out.println("已赋值为false");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
