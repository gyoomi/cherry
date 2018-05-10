/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_threadgroup;

/**
 * 线程关联线程组：1级关联
 *    1级关联就是父对象中有子对象，但并不创建孙对象。这种情况在开发中很常见，比如创建一些线程时，为了有效对这些线程进行阻止管理，
 *    通常情况下是创建一个线程组，然后再将部分线程归属到该组中，以此来对零散的线程对象进行有效的管理
 *
 * 注意：线程必须启动后才能归到指定线程组中
 *
 * @author Leon
 * @version 2018/5/10 11:49
 */
public class Thread44Client {

    public static void main(String[] args) {
        Thread44_00 t4400 = new Thread44_00();
        Thread44_00 t4401 = new Thread44_00();
        ThreadGroup tg = new ThreadGroup("新建线程组1111");
        Thread t0 = new Thread(tg, t4400);
        Thread t1 = new Thread(tg, t4401);
        t0.start();
        t1.start();
        System.out.println("当前活动的线程数：" + tg.activeCount());
        System.out.println("当前活动的线程组名称:" + tg.getName());
    }
}
