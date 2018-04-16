/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.designpattern.factory.simplefactory;

/**
 * 工厂类
 *
 * @author Leon
 * @version 2018/4/16 15:17
 */
public class AnimalFactory {

    private AnimalFactory(){}

    public static Animal createAnimal(String acturalType){
        if ("dog".equals(acturalType)) {
            return new Dog();
        } else if ("cat".equals(acturalType)){
            return new Cat();
        } else if ("bird".equals(acturalType)){
            return new Bird();
        } else {
            System.err.println("init failed, acturalType is " + acturalType);
            return null;
        }
    }
}
