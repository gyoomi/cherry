/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.designpattern.factory.simplefactory;

/**
 * 测试类
 *
 * @author Leon
 * @version 2018/4/16 15:22
 */
public class Test {
    public static void main(String[] args) {
        Animal dog = AnimalFactory.createAnimal("dog");
        dog.sleep();
        Animal cat = AnimalFactory.createAnimal("cat");
        cat.sleep();
        Animal bird = AnimalFactory.createAnimal("bird");
        bird.sleep();
        Animal hema = AnimalFactory.createAnimal("hema");
        hema.sleep();
    }
}
