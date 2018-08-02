/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.k_lambda;

import java.text.DecimalFormat;
import java.util.function.Function;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/8/1 14:38
 */

class MyMoney {
    private final int money;

    public MyMoney(int money) {
        this.money = money;
    }

    public void printMoney(Function<Integer, String> moneyFormat) {
        System.out.println("我的存款是：" + moneyFormat.apply(this.money));
    }
}
public class MoneyDemo {

    public static void main(String[] args) {
        MyMoney myMoney = new MyMoney(99999999);
        Function<Integer, String> format = m -> new DecimalFormat("#,###").format(m);
        // System.out.println(format.apply(10000000));
        // 函数接口的链式调用
        myMoney.printMoney(format.andThen(s -> "rmb:" + s));
    }
}
