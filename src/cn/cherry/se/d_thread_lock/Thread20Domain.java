/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_lock;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/5/8 9:07
 */
public class Thread20Domain {

    private String username;
    private String password;
    private String anything = new String();

    public void setUsernamePassword(String username, String password) {
        try {
            synchronized (anything) {
                System.out.println("线程名字：" + Thread.currentThread().getName() + "在 " + System.currentTimeMillis() + "进入代码块");
                this.username = username;
                Thread.sleep(1000);
                this.password = password;
                System.out.println("线程名字：" + Thread.currentThread().getName() + "在 " + System.currentTimeMillis() + "离开代码块");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
