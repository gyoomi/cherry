/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.k_lambda;

import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/8/1 18:11
 */
class MyLazy {
    private final IntSupplier data;

    public MyLazy (IntSupplier data) {
        this.data = data;
    }

    // 中间操作，不调用最终的操作value,那么op就不会执行
    public MyLazy some(IntUnaryOperator op) {
        // 为了不影响之前数据，每次返回一个新对象
        return new MyLazy(() -> op.applyAsInt(this.data.getAsInt()));
    }

    // 最终操作
    public int value() {
        return this.data.getAsInt();
    }
}

public class LazyDemo02 {

    public static void main(String[] args) {
        MyLazy lazy = new MyLazy(()-> 12);
        int value = lazy.some(LazyDemo02::doubleNumber).some(LazyDemo02::doubleNumber).value();
        // 中间操作没有被调用
        System.out.println(value);
        System.out.println("-------");
        // IntStream.range(1, 100).forEach(System.out::println);

        // map 就是流里面的中间操作
        // sum 就是流里面的最终操作
        // 假设流里面不调用最终操作，那么所有的中间操作都不会真正被执行
        // 这就是流的惰性求值
        // 下面的代码不执行sum这种最终操作
        IntStream.rangeClosed(1, 19).map(LazyDemo02::doubleNumber);
        // 下面的中间操作会执行
        System.out.println("*************");
        IntStream.rangeClosed(1, 20).map(LazyDemo02::doubleNumber).sum();
    }

    public static int doubleNumber(int i) {
        System.out.println("方法被调用了");
        return i * 2;
    }
}
