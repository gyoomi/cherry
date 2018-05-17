/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.designpattern.decorator.demo;

/**
 * 具体装饰者：摩卡
 *
 * @author Leon
 * @version 2018/5/17 16:10
 */
public class Mocha extends Condiment {

    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    /**
     * 我们期望得到描述是不仅仅只有进料，而是一个链式描述
     *
     * @return
     */
    @Override
    public String getDescription() {
        return beverage.getDescription() + " , Mocha ";
    }

    @Override
    public double cost() {
        return beverage.cost() + 5.0;
    }
}
