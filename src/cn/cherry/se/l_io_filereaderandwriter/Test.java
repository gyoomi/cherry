/**
 * Copyright © 2018, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.l_io_filereaderandwriter;

import java.io.FileReader;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/6/7 22:30
 */
public class Test {

    public static void main(String[] args) throws Exception {
        read02();
    }

    /**
     * 读文件的第一种方式
     *
     * @throws Exception
     */
    public static void read01() throws Exception {
        FileReader reader = new FileReader("d:\\1.txt");
        char[] buff = new char[1024];
        int len;
        while ((len = reader.read(buff, 0 , 1024)) != -1) {
            System.out.println(new String(buff, 0 ,len));
        }
        reader.close();
    }

    public static void read02() throws Exception {
        FileReader reader = new FileReader("d:\\1.txt");
        int len;
        while ((len = reader.read()) != -1) {
            System.out.println((char)len);
        }
        reader.close();
    }
}
