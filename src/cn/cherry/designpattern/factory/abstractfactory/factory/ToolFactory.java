/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.designpattern.factory.abstractfactory.factory;

import cn.cherry.designpattern.factory.abstractfactory.bean.Car;
import cn.cherry.designpattern.factory.abstractfactory.bean.Moto;

/**
 * 抽象工厂
 *
 * @author Leon
 * @version 2018/4/19 17:09
 */
public interface ToolFactory {
    Car getCarInstance();
    Moto getMotoInstance();
}
