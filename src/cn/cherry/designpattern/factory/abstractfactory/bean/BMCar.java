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
 * @version 2018/4/19 16:52
 */
public class BMCar implements Car {
    @Override
    public void start() {
        System.out.println("宝马启动了...");
    }

    @Override
    public void stop() {
        System.out.println("宝马熄火了...");
    }
}
