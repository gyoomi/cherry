/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.designpattern.decorator.demo;

/**
 * 具体组件：雀巢咖啡（也是一种饮料）
 *
 * @author Leon
 * @version 2018/5/17 16:06
 */
public class QueChaoCoffee extends Beverage {

    public QueChaoCoffee() {
        description = "雀巢咖啡";
    }

    @Override
    public double cost() {
        return 5.0;
    }
}
