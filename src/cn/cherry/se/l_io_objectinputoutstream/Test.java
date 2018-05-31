/**
 * Copyright © 2018, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.l_io_objectinputoutstream;

import java.io.*;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/5/31 21:59
 */
public class Test {

    public static void main(String[] args) {
        readObj();
    }

    public static void writeObj() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:\\stu.dat"));
            Student stu = new Student();
            stu.setId(1001);
            stu.setName("tom");
            stu.setSex("male");
            oos.writeObject(stu);
            oos.close();
            System.out.println("over");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readObj() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\stu.dat"));
            Student s = (Student) ois.readObject();
            ois.close();
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
