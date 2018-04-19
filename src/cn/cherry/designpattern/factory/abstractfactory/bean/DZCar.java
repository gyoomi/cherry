/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.designpattern.factory.abstractfactory.bean;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/4/19 16:53
 */
public class DZCar implements Car {
    @Override
    public void start() {
        System.out.println("大众启动了...");
    }

    @Override
    public void stop() {
        System.out.println("大众熄火了...");
    }
}
