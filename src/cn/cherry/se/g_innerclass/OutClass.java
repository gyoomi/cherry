/**
 * Copyright © 2018, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.g_innerclass;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/5/2 21:45
 */
public class OutClass {

    private static final String str = "outStr";

    public class InnerClass{
        private String str = "innerStr";

        public void test(){
            String str = "testStr";
            // 局部变量
            System.out.println(str);
            // 类变量
            System.out.println(this.str);
            // 外部类变量
            // System.out.println(OutClass.this.str);
        }
    }

    public static class StaticInnerClass{
        private String str = "staticStr";

        public void test(){
            String str = "testStr";
            // 局部变量
            System.out.println(str);
            // 类变量
            System.out.println(this.str);
            // 外部类变量
            System.out.println(OutClass.str);
        }
    }


    public static void main(String[] args) {
        // 外部类初始化
        OutClass out = new OutClass();
        // 内部类初始化
        OutClass.InnerClass i1 = out.new InnerClass();
        i1.test();
        // 静态内部类的初始化
        OutClass.StaticInnerClass staticClass = new StaticInnerClass();
        System.out.println("----------------");
        staticClass.test();

    }
}
