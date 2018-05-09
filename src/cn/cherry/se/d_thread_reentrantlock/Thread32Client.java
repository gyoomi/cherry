/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_reentrantlock;

/**
 * synchronized与wait()和nitofy()/notifyAll()方法相结合可以实现等待/通知模型，ReentrantLock同样可以，但是需要借助Condition，且Condition有更好的灵活性，具体体现在
 *
 *     1.一个Lock里面可以创建多个Condition实例，实现多路通知
 *     2.notify()方法进行通知时，被通知的线程时Java虚拟机随机选择的，但是ReentrantLock结合Condition可以实现有选择性地通知，这是非常重要的
 *     3.看一下利用Condition实现等待/通知模型的最简单用法，下面的代码注意一下，await()和signal()之前，必须要先lock()获得锁，使用完毕在finally中unlock()释放锁，这和wait()/notify()/notifyAll()使用前必须先获得对象锁是一样的.
 *
 * @author Leon
 * @version 2018/5/9 11:34
 */
public class Thread32Client {

    public static void main(String[] args) {
        Thread32Domain td = new Thread32Domain();
        Thread32_00 t3200 = new Thread32_00(td);
        Thread32_01 t3201 = new Thread32_01(td);
        t3200.start();
        t3201.start();
    }
}
