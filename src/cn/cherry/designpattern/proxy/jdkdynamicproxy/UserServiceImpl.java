/**
 * Copyright © 2018, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.designpattern.proxy.jdkdynamicproxy;

/**
 * UserServiceImpl
 *
 * @author Leon
 * @version 2018/4/22 23:17
 */
public class UserServiceImpl implements UserService {
    @Override
    public String login(String username, String pwd) {
        System.out.println("login...");
        return "ok";
    }
}
