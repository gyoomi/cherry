/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.designpattern.decorator;

/**
 * Decorator装饰角色:
 *     一般是个抽象类，用来实现接口或抽象方法，它里面可以定有抽象的方法，但是他的属性里面必然有一个私有的变量指向Component抽象构件
 *
 * @author Leon
 * @version 2018/5/16 15:21
 */
public abstract class Decorator extends Component{

    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operate() {
        this.component.operate();
    }
}
