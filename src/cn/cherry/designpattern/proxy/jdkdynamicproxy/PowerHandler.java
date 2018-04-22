/**
 * Copyright © 2018, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.designpattern.proxy.jdkdynamicproxy;

/**
 * 增强类
 *
 * @author Leon
 * @version 2018/4/22 23:18
 */
public class PowerHandler {
    public void before(){
        System.out.println("性能检测Start...");
    }

    public void after(){
        System.out.println("性能检测End...");
    }
}
