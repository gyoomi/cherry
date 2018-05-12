/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.l_io_inputstream;

import java.io.*;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/5/12 10:20
 */
public class FileInputStreamTest {

    public static void main(String[] args) {
        test01();
    }

    public static void test01() {
        try {
            File file = new File("D:\\1.txt");
            int length = (int) file.length();
            InputStream in = new FileInputStream(file);
            int len;
            while ((len = in.read()) != -1) {
                System.out.print((char)len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
