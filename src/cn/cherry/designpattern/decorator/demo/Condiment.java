/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.designpattern.decorator.demo;

/**
 * 抽象装饰者：调料
 *
 * @author Leon
 * @version 2018/5/17 15:57
 */
public abstract class Condiment extends Beverage{

    /**
     * 所有的调料装饰类，必须重写此方法
     *
     * @return
     */
    @Override
    public abstract String getDescription();
}
