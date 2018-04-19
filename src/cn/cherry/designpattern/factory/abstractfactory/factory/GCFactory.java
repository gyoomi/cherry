/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.designpattern.factory.abstractfactory.factory;

import cn.cherry.designpattern.factory.abstractfactory.bean.Car;
import cn.cherry.designpattern.factory.abstractfactory.bean.DZCar;
import cn.cherry.designpattern.factory.abstractfactory.bean.JLMoto;
import cn.cherry.designpattern.factory.abstractfactory.bean.Moto;

/**
 * 国产摩托车工厂
 *
 * @author Leon
 * @version 2018/4/19 17:12
 */
public class GCFactory implements ToolFactory {
    @Override
    public Car getCarInstance() {
        return new DZCar();
    }

    @Override
    public Moto getMotoInstance() {
        return new JLMoto();
    }
}
