/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_volatile;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/5/8 10:29
 */
public class Thread22_00 extends Thread {

    private volatile boolean isRunning = true;

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    @Override
    public void run() {
            System.out.println("进入了run方法");
            while (isRunning == true) {
                // System.out.println(999);
            }
            System.out.println("线程被停止了");
    }
}
