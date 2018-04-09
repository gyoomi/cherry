/**
 * Copyright © 2018, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.a_newjdk8;

/**
 * 接口功能描述
 *
 * @author Leon
 * @version 2018/4/9 22:25
 */
class Test2{

    public static void main(String[] args) {
        TestInterface ti = new TestClass();
        ti.print();
        TestInterface.prinf();
    }
}

public interface TestInterface {

    /**
     * 一般方法需要添加default方法
     *
     */
    default void print(){
        System.out.println("接口中方法可以有方法体了");
    }

    /**
     * 接口中静态方法直接有方法体了
     *
     */
    static void prinf(){
        System.out.println("接口中的静态方法可以有方法体了");
    }
}

class TestClass implements TestInterface{

}
