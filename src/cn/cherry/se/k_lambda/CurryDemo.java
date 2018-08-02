/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.k_lambda;

import java.util.function.Function;

/**
 * 级联表达式和柯里化
 * 柯里化:把多个参数的函数转换为只有一个参数的函数
 * 里化的目的：函数标准化
 * 高阶函数：就是返回函数的函数
 *
 * @author Leon
 * @version 2018/8/2 16:23
 */
public class CurryDemo {

    public static void main(String[] args) {
        Function<Integer, Function<Integer, Integer>> demo = x -> y -> x + y;
        System.out.println(demo.apply(2).apply(3));
        System.out.println("--------------");
        Function<Integer, Function<Integer, Function<Integer, Integer>>> demo2 = x -> y -> z -> x + y + z;
        System.out.println(demo2.apply(1).apply(2));
        System.out.println("--------------");
        int[] nums = {2, 3, 4};
        Function f = demo2;
        for (int i = 0; i < nums.length; i++) {
            if (f instanceof Function) {
                Object obj = f.apply(nums[i]);
                if (obj instanceof Function) {
                    f = (Function) obj;
                } else {
                    System.out.println("调用完毕： 结果为" + obj);
                }
            }
        }
    }
}
