/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_othercomponent;

import java.util.concurrent.Exchanger;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/5/11 11:17
 */
public class ExchangerTest {

    static class ExchangerThread extends Thread {

        private String str;
        private Exchanger<String> exchanger;
        private int sleepSecond;

        public ExchangerThread(String str, Exchanger<String> exchanger, int sleepSecond) {
            this.str = str;
            this.exchanger = exchanger;
            this.sleepSecond = sleepSecond;
        }

        @Override
        public void run() {
            try {
                System.out.println(this.getName() + " Start... 原始数据为：" + str + " Time = " + System.currentTimeMillis());
                Thread.sleep(sleepSecond * 1000);
                str = exchanger.exchange(str);
                System.out.println(this.getName() + " Start... 交换了数据，交换后的数据为：" + str + " Time = " + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        ExchangerThread et0 = new ExchangerThread("111", exchanger, 3);
        ExchangerThread et1 = new ExchangerThread("AAA", exchanger, 2);
        et0.start();
        et1.start();
    }

    /**
     * 看到两个线程交换了数据，由于一个线程睡2秒、一个线程睡3秒，既然要交换数据，肯定是睡2秒的要等待睡3秒的，所以看到时间差是3000ms即3s。
     *     从这个例子看来，Exchanger有点像之前Java多线程15：Queue、BlockingQueue以及利用BlockingQueue实现生产者/消费者模型
     *     一文中的SynchronousQueue的双向形式，它可能在遗传算法和管道设计中很有用。
     *
     *
     */
}
