/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.designpattern.decorator.demo;

/**
 * 具体组件：浓缩咖啡（也是一种饮料）
 *
 * @author Leon
 * @version 2018/5/17 16:01
 */
public class NongSuoCoffee extends Beverage {

    public NongSuoCoffee() {
        description = "浓缩咖啡";
    }

    @Override
    public double cost() {
        return 10.0;
    }
}
