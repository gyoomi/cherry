/**
 * Copyright © 2018, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.designpattern.proxy.jdkdynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 测绘类  jdk动态代理测试
 *
 * @author Leon
 * @version 2018/4/22 23:19
 */
public class Client {

    public static void main(String[] args) {
        final UserServiceImpl userService = new UserServiceImpl();
        final PowerHandler pw = new PowerHandler();
        UserService u = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                pw.before();
                Object obj = method.invoke(userService, args);
                pw.after();
                return obj;
            }
        });
        String str = u.login("111", "456");
        System.out.println(str);
    }
}
