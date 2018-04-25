/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.c_initorderinclass;

/**
 * 派生类
 *
 * @author Leon
 * @version 2018/4/25 16:16
 */
public class Dog extends Animal {
    public Dog(){
        System.out.println("dog constructor method do...");
    }

    {
        System.out.println("dog constructor block do...");
    }

    static {
        System.out.println("dog static block do...");
    }

}
