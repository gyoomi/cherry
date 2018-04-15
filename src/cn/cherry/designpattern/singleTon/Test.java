/**
 * Copyright © 2018, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.designpattern.singleTon;

/**
 * 单例设计模式
 *
 * @author Leon
 * @version 2018/4/15 22:08
 */
public class Test {
}

class SingleTon1{

    /**
     * 饿汉式：常量式。推荐使用
     */
    private static final SingleTon1 s = new SingleTon1();

    public SingleTon1 getInstance(){
        return s;
    }
}

class SingleTon2{
    /**
     * 饱汉式
     */
    private static SingleTon2 s;

    private SingleTon2(){}

    /**
     *双重加锁机制：
     * 在懒汉式实现单例模式的代码中，有使用synchronized关键字来同步获取实例，保证单例的唯一性，
     * 但是上面的代码在每一次执行时都要进行同步和判断，无疑会拖慢速度，使用双重加锁机制正好
     * 可以解决这个问题。
     *
     *
     * 不推荐使用，使用了双重加锁机制。
     * @return
     */
    public SingleTon2 getInstance(){
        if (s == null) {
            synchronized (SingleTon2.class) {
                if (s == null) {
                    s = new SingleTon2();
                }
            }
        }
        return s;
    }

}

class SingleTon3{

    private static volatile SingleTon3 s;
    private SingleTon3() {}

    public SingleTon3 getInstance(){
        if (s == null){
            synchronized (SingleTon3.class){
                if (s == null){
                    s = new SingleTon3();
                }
            }
        }
        return s;
    }
}
