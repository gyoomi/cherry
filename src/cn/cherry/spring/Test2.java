/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.spring;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/4/20 10:24
 */
public class Test2 {
    public Test2(){
        System.out.println(this);
        System.out.println(this.getClass());
    }
    public static void main(String[] args) {
        Test2 t2 = new Test2();
    }
}
