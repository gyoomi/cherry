/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.designpattern.factory.abstractfactory.client;

import cn.cherry.designpattern.factory.abstractfactory.factory.*;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/4/19 16:56
 */
public class Client {
    public static void main(String[] args) {
        ToolFactory gcf = new GCFactory();
        gcf.getCarInstance().start();
        gcf.getMotoInstance().start();
        ToolFactory jkf  = new JKFactory();
        jkf.getCarInstance().start();
        jkf.getMotoInstance().start();
    }

    public void test01(){
        ICarFactory bmf = new BMCarFactory();
        bmf.createCarInstance().start();
        ICarFactory dzf = new DZCarFactory();
        dzf.createCarInstance().start();
    }
}
