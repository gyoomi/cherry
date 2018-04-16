/**
 * Copyright © 2018, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.designpattern.factory.factorymethod.dao;

import cn.cherry.spring.User;

/**
 * MySQLUserDaoImpl 实现类
 *
 * @author Leon
 * @version 2018/4/16 22:44
 */
public class MySQLUserDaoImpl implements IUserDao {
    @Override
    public void addUser() {
        System.out.println("mysql add user...");
    }

    @Override
    public void deleteUser(String id) {
        System.out.println("mysql delete user...");
    }

    @Override
    public User getUser(String id) {
        User user = new User();
        user.setName("mysql");
        return user;
    }
}
