/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.q_netty_marshalling;

import java.io.Serializable;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/7/10 15:04
 */
public class Response implements Serializable {

    private int age;
    private String name;

    public Response() {}

    public Response(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Response{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
