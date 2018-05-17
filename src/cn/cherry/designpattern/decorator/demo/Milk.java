/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.designpattern.decorator.demo;

/**
 * 具体装饰者：牛奶
 *
 * @author Leon
 * @version 2018/5/17 16:17
 */
public class Milk extends Condiment {

    Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ",Milk ";
    }

    @Override
    public double cost() {
        return beverage.cost() + 4.0;
    }
}
