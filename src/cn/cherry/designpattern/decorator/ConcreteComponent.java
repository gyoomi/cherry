/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.designpattern.decorator;

/**
 * ConcreteComponent是最核心、最原始、最基本的接口或抽象类的实现，你需要装饰的就是它
 *
 * @author Leon
 * @version 2018/5/16 15:19
 */
public class ConcreteComponent extends Component {

    @Override
    public void operate() {
        System.out.println("do something...");
    }
}
