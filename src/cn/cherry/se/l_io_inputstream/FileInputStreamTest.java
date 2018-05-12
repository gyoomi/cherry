/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.l_io_inputstream;

import com.sun.org.apache.xpath.internal.operations.String;

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
            byte[] bArr = new byte[length];
            int read = in.read(bArr);
            System.out.println(new String());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
