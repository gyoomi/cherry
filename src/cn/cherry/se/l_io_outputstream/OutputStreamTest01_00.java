/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.l_io_outputstream;

import java.io.*;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/5/14 9:11
 */
public class OutputStreamTest01_00 {

    public static void main(String[] args) {
        test02();
    }

    /**
     * 写：字符->字节
     *
     */
    public static void test01() {
        try {
            File file = new File("d:\\stream.txt");
            OutputStream out = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
            osw.write("这是我的风啊啊啊！！");
            osw.close();
            System.out.println("over");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

    /**
     * 字符转字节
     *
     */
    public static void test02() {
        try {
            File file = new File("D:\\dddd.txt");
            InputStream in = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(in, "unicode");
            int read = 0;
            while ((read = isr.read()) != -1) {
                System.out.println((char)read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
