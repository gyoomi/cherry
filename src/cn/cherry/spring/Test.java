/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.spring;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * XmlBeanFactory的初始化
 *
 * @author Leon
 * @version 2018/4/16 17:23
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("D:/gyoomi/idea-workspace2/cherry/out/production/cherry/spring.xml");
        User user = context.getBean(User.class);
        System.out.println(user);
    }

    public void test01() {
        // 定位resource位置
        ClassPathResource resource = new ClassPathResource("spring.xml");
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        // XmlBeanDefinitionReader读取器，用于载入BeanDefinition。之所以需要BeanFactory作为参数，是因为会将读取的信息回调配置给factory
        // XmlBeanDefinitonReader读取器，用于载入BeanDefinition。之所以需要BeanFactory作为参数，因为读取信息会回调配置factory
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        int i = reader.loadBeanDefinitions(resource);
        System.out.println(i);
    }
}
