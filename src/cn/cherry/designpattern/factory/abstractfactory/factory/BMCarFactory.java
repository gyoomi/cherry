/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.designpattern.factory.abstractfactory.factory;

import cn.cherry.designpattern.factory.abstractfactory.bean.BMCar;
import cn.cherry.designpattern.factory.abstractfactory.bean.Car;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/4/19 16:55
 */
@Deprecated
public class BMCarFactory implements ICarFactory {
    @Override
    public Car createCarInstance() {
        return new BMCar();
    }
}
