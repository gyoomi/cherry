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
 * @version 2018/5/7 13:48
 */
public class Client12 {

    /**
     * 测试当前线程是否已经中断，执行后具有将状态标识清除为false的功能。
     * 换句话说，如果连续两次调用该方法，那么返回的必定是false：
     *
     * @param args
     */
    public static void main(String[] args) {
        Thread.currentThread().interrupt();
        System.out.println(Thread.currentThread().isInterrupted());
        System.out.println(Thread.currentThread().isInterrupted());
        System.out.println(Thread.currentThread().isInterrupted());
        System.out.println("over");
    }
}
