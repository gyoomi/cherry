/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.designpattern.decorator;

/**
 * 客户端
 *
 * @author Leon
 * @version 2018/5/16 15:51
 */
public class Client {

    public static void main(String[] args) {
        ConcreteComponent cc = new ConcreteComponent();
        ConcreteDecoratorA cda = new ConcreteDecoratorA(cc);
        ConcreteDecoratorB cdb = new ConcreteDecoratorB(cda);
        cdb.operate();
    }

}
