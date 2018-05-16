/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.designpattern.decorator;

/**
 * 具体装饰角色ConcreteDecoratorA
 *     ConcreteDecoratorA和ConcreteDecoratorB是两个具体的装饰类，你要把你最核心的、最原始的、最基本的东西装饰成其他东西
 *
 * @author Leon
 * @version 2018/5/16 15:29
 */
public class ConcreteDecoratorA extends Decorator{


    /**
     * 定义被修饰者
     *
     * @param component
     */
    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    public void methodA() {
        System.out.println("methodA 修饰");
    }

    @Override
    public void operate() {
        super.operate();
        this.methodA();
    }

}
