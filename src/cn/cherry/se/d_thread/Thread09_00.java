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
 * @version 2018/5/7 11:06
 */
public class Thread09_00 extends Thread {

    static {
        System.out.println("静态代码块打印：" + Thread.currentThread().getName());
    }
    public Thread09_00(){
        System.out.println("构造方法代码块打印：" + Thread.currentThread().getName());
    }
    @Override
    public void run() {
        System.out.println("run()方法的打印：" + Thread.currentThread().getName());
    }
}
