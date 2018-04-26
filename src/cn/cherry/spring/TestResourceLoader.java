/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.spring;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/4/20 10:24
 */
public class TestResourceLoader {
    public static void test2(){
        for (int i = 0; i <= 10; i++) {
            if ( i == 5){
                continue;
            }
            if (i == 7){
                break;
            }
            System.out.println(i);
        }

    }

    public static void test1(){
        int i = 0;
        for(;;){
            i++;
            System.out.println(i);
            if (( i % 2 ) == 0){
                continue;
            }
            if ( i > 10000){
                break;
            }
        }
    }

    public static void main(String[] args) {
        DefaultResourceLoader loader = new DefaultResourceLoader();
        Resource r1 = loader.getResource("/spring.xml");
        System.out.println(r1);
        System.out.println(r1.getClass());
        Resource r2 = loader.getResource("classpath:spring.xml");
        System.out.println(r2);
        System.out.println(r2.getClass());
        Resource r3 = loader.getResource("https://blog.csdn.net/u011179993/article/details/51531140");
        System.out.println(r3);
        System.out.println(r3.getClass());
        Resource r4 = loader.getResource("hello resource loader");
        System.out.println(r4);
        System.out.println(r4.getClass());
    }

}
