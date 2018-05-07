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
 * @version 2018/5/7 9:47
 */
public class Thread04_00 extends Thread {

    @Override
    public void run() {
        System.out.println(this.getId() + ":" + this.getName() + "--->" + this.getPriority());
    }
}
