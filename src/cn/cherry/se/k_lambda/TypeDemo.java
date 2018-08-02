/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.k_lambda;
@FunctionalInterface
interface IMath {
    int add(int x, int y);
}

@FunctionalInterface
interface IMath2 {
    int sub(int x, int y);
}
/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/8/1 14:03
 */
public class TypeDemo {

    public static void main(String[] args) {
        // 变量类型定义
        IMath lambda = (x, y) -> x + y;
        // 数组里
        IMath[] lambda2 = {(x, y) -> x + y};
        // 强转
        Object lambad3 = (IMath)(x, y) -> x + y;

        // 当接口有二义性的时候，通过强转成对应的类型即可
        TypeDemo typeDemo = new TypeDemo();
        typeDemo.test((IMath2) (x, y) -> x + y);

    }

    public void test(IMath math) {

    }

    public void test(IMath2 math2) {

    }
}
