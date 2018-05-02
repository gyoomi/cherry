/**
 * Copyright © 2018, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.spring;

import cn.cherry.spring.bean.Dept;
import cn.cherry.spring.bean.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/4/26 21:20
 */
public class TestFileSystemXmlApplicationContext {
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("D:/gyoomi/idea-workspace2/cherry/out/production/cherry/spring.xml");
        User user = context.getBean(User.class);
        Dept dept = context.getBean(Dept.class);
        System.out.println(user);
        System.out.println(dept);
    }
}
