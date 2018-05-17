/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.designpattern.decorator.demo;

/**
 * 消费终端
 *
 * @author Leon
 * @version 2018/5/17 16:21
 */
public class Client {

    public static void main(String[] args) {
        Beverage beverage = new QueChaoCoffee();
        Milk milk = new Milk(beverage);
        System.out.println(beverage.getDescription());
        System.out.println(beverage.cost());
        System.out.println("------------------------");
        System.out.println(milk.getDescription());
        System.out.println(milk.cost());
        System.out.println("-----------------------");
        Mocha mocha = new Mocha(milk);
        System.out.println(mocha.getDescription());
        System.out.println(mocha.cost());
    }

}
