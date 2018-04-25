/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.c_initorderinclass;

/**
 * 基类
 *
 * @author Leon
 * @version 2018/4/25 16:14
 */
public class Animal {
    private String id;
    private String name;

    public Animal(){
        System.out.println("animal constructor method do...");
    }

    {
        System.out.println("animal constructor block do...");
    }

    static {
        System.out.println("animal static block do...");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
