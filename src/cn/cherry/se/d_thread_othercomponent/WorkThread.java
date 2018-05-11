/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_othercomponent;

import java.util.concurrent.CountDownLatch;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/5/11 9:55
 */
public class WorkThread extends Thread {

    private CountDownLatch cdLatch;
    private int sleepSecond;

    public WorkThread(String name, CountDownLatch cdLatch, int sleepSecond) {
        super(name);
        this.cdLatch = cdLatch;
        this.sleepSecond = sleepSecond;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.getName() + " 启动了，Time = " + System.currentTimeMillis());
            Thread.sleep(sleepSecond * 1000);
            cdLatch.countDown();
            System.out.println(this.getName() + " 执行完毕，Time = " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class DoneThread extends  Thread {
        private CountDownLatch cdLatch;

        public DoneThread(String name, CountDownLatch cdLatch) {
            super(name);
            this.cdLatch = cdLatch;
        }

        @Override
        public void run() {
            try {
                System.out.println(this.getName() + " 要等待了，Time = " + System.currentTimeMillis());
                cdLatch.await();
                System.out.println(this.getName() + " 等待完毕，Time = " + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * 效果十分明显，解释一下：
     *
     * 1、启动2个线程DoneThread线程等待3个WorkThread全部执行完
     *
     * 2、3个WorkThread全部执行完，最后执行完的WorkThread3执行了秒符合预期
     *
     * 3、后三句从时间上看几乎同时出现，说明CountDownLatch设置为3，WorkThread3执行完，两个wait的线程马上就执行后面的代码了
     *
     * 这相当于是一种进化版本的等待/通知机制，它可以的实现的是多个工作线程完成任务后通知多个等待线程开始工作，之前的都是一个工作线程完成任务通知一个等待线程或者一个工作线程完成任务通知所有等待线程。
     *
     * CountDownLatch其实是很有用的，特别适合这种将一个问题分割成N个部分的场景，所有子部分完成后，通知别的一个/几个线程开始工作。比如我要统计C、D、E、F盘的文件，可以开4个线程，分别统计C、D、E、F盘的文件，统计完成把文件信息汇总到另一个/几个线程中进行处理
     *
     * @param args
     */
    public static void main(String[] args) {
        CountDownLatch cd = new CountDownLatch(3);
        DoneThread dt0 = new DoneThread("doneThread1", cd);
        DoneThread dt1 = new DoneThread("doneThread2", cd);
        dt0.start();
        dt1.start();
        WorkThread wt0 = new WorkThread("workThread1", cd, 2);
        WorkThread wt1 = new WorkThread("workThread1", cd, 3);
        WorkThread wt2 = new WorkThread("workThread1", cd, 4);
        wt0.start();
        wt1.start();
        wt2.start();
    }
}
