/**
 * Copyright © 2018, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.designpattern.factory.factorymethod.dao;

import cn.cherry.spring.User;

/**
 * IUserDao Interface
 *
 * @author Leon
 * @version 2018/4/16 22:42
 */
public interface IUserDao {

    void addUser();

    void deleteUser(String id);

    User getUser(String id);
}
