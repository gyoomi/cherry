/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.designpattern.decorator;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/5/16 15:49
 */
public class ConcreteDecoratorB extends Decorator {

    /**
     * 定义被修饰者
     *
     * @param component
     */
    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    @Override
    public void operate() {
        super.operate();
        this.methodB();
    }

    public void methodB() {
        System.out.println("methodB 修饰");
    }
}
