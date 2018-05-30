/**
 * Copyright © 2018, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.n_serializable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/5/30 21:59
 */
public class Test {

    public static void main(String[] args) {
        try {
            Student  stu1 = new Student(1001, "jack", "play");
            Student  stu2 = new Student(1002, "tom", "sleep");
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:\\stu.dat"));
            oos.writeObject(stu1);
            oos.writeObject(stu2);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
