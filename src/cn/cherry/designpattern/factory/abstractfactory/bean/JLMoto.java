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
 * @version 2018/4/19 16:59
 */
public class JLMoto implements Moto {
    @Override
    public void start() {
        System.out.println("嘉林摩托启动了...");
    }

    @Override
    public void stop() {
        System.out.println("嘉林摩托熄火了...");
    }
}
