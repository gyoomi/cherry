/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.designpattern.factory.abstractfactory.factory;

import cn.cherry.designpattern.factory.abstractfactory.bean.BMCar;
import cn.cherry.designpattern.factory.abstractfactory.bean.Car;
import cn.cherry.designpattern.factory.abstractfactory.bean.HLMoto;
import cn.cherry.designpattern.factory.abstractfactory.bean.Moto;

/**
 * 进口摩托车工厂
 *
 * @author Leon
 * @version 2018/4/19 17:14
 */
public class JKFactory implements ToolFactory {
    @Override
    public Car getCarInstance() {
        return new BMCar();
    }

    @Override
    public Moto getMotoInstance() {
        return new HLMoto();
    }
}
