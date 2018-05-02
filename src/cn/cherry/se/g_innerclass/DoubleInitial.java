/**
 * Copyright © 2018, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.g_innerclass;

import java.util.ArrayList;
import java.util.List;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/5/2 22:19
 */
public class DoubleInitial {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("tom");
        list.add("jack");
        print(list);

        // 双括号初始化
        // 外层括号建立了一个ArrayList的匿名子类，内层则是一个对象的构造代码块
        print(new ArrayList<String>(){{add("1111"); add("222");}});
    }

    public static void print(List list){
        list.forEach(e ->{
            System.out.println(e);
        });
    }
}
