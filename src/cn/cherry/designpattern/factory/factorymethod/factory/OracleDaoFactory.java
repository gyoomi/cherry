/**
 * Copyright © 2018, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.designpattern.factory.factorymethod.factory;

import cn.cherry.designpattern.factory.factorymethod.dao.IUserDao;
import cn.cherry.designpattern.factory.factorymethod.dao.OracleUserDaoImpl;

/**
 * OracleDaoFactory
 *
 * @author Leon
 * @version 2018/4/16 22:50
 */
public class OracleDaoFactory implements IDaoFactory {
    @Override
    public IUserDao createUserDao() {
        return new OracleUserDaoImpl();
    }
}
