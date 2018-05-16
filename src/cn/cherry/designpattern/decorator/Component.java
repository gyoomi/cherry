/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.designpattern.decorator;

/**
 * 1.Component是一个接口或者是抽象类，就是定义我们最核心的对象，也就是最原始的对象
 * 2.在装饰模式中，必然有一个最基本、最核心、最原始的接口或抽象类充当Component抽象构件。
 *
 * @author Leon
 * @version 2018/5/16 15:16
 */
public abstract class Component {

    public abstract void operate();

}
