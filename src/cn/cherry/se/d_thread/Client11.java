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
 * @version 2018/5/7 13:43
 */
public class Client11 {

    /**
     * 暂停当前执行的线程对象，并执行其他线程。这个暂停是会放弃CPU资源的，并且放弃CPU的时间不确定，
     * 有可能刚放弃，就获得CPU资源了，也有可能放弃好一会儿，才会被CPU执行。
     *
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread11_00 t1100 = new Thread11_00();
            t1100.start();
        }
    }
}
