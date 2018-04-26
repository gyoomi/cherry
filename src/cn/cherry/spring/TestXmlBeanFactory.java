/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.spring;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/4/26 13:53
 */
public class TestXmlBeanFactory {
    public static void main(String[] args) {
        // 获取资源文件
        ClassPathResource resource = new ClassPathResource("spring.xml");
        // 获取Bean Factory Ioc容器；同时DefaultListableBeanFactory是BeanDefinitionRegistry的一个实现类，
        // 所以该Factory也是BeanDefinitionRegistry
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        // 读取resource文件，初始化Ioc容器
        int i = reader.loadBeanDefinitions(resource);
        System.out.println(i);
    }
}
