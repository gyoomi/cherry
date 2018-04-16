/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.designpattern.factory.simplefactory;

/**
 * 具体产品3
 *
 * @author Leon
 * @version 2018/4/16 15:16
 */
public class Bird implements Animal {
    @Override
    public void eat() {
        System.out.println("bird eat worms...");
    }

    @Override
    public void sleep() {
        System.out.println("bird sleep in the nest...");
    }
}
