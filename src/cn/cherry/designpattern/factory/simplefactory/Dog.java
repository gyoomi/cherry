/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.designpattern.factory.simplefactory;

/**
 * 具体产品角色1
 *
 * @author Leon
 * @version 2018/4/16 15:13
 */
public class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("dog eat meat...");
    }

    @Override
    public void sleep() {
        System.out.println("dog not sleep ,look dooring...");
    }
}
