/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.k_lambda;

import java.util.function.*;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/8/1 15:05
 */
class Dog {
    private String name = "XiaoTianDog";
    private int food = 10;

    public Dog() {}
    public Dog(String name) {
        this.name = name;
    }

    public static void bark(Dog dog) {
        System.out.println(dog + "叫了");
    }

    /* 默认会把当前实例传入到非静态方法，参数名为this，位置是第一个 */
    public int eat(int x) {
        System.out.println("吃了" + x + "斤狗粮");
        this.food -= x;
        return this.food;
    }

    @Override
    public String toString() {
        return this.name + "DOG";
    }
}
public class MethodReference {

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat(3);
        // 方法引用
        Consumer<String> consumer = System.out::println;
        consumer.accept("hello");
        // 静态方法的引用
        Consumer<Dog> barkConsumer = Dog::bark;
        barkConsumer.accept(dog);
        // 非静态方法的引用
        // Function<Integer, Integer> eatFunction = dog::eat;
        // UnaryOperator<Integer> eatFunction = dog::eat; /* 一元操作 */
        IntUnaryOperator intUnaryOperator = dog::eat;
        intUnaryOperator.applyAsInt(2);
        // 使用类名来调用实例方法
        BiFunction<Dog, Integer, Integer> biFunction = Dog::eat;
        Integer remain = biFunction.apply(dog, 2);
        // 构造方法的引用
        Supplier<Dog> supplier = Dog::new;
        System.out.println(supplier.get());
        // 带参数的构造方法的引用
        Function<String, Dog> dog2= Dog::new;
        System.out.println("dog2 是：" + dog2.apply("旺财"));
        System.out.println("剩余" + remain + "斤");
    }
}
