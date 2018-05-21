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
        test05();
    }


    /**
     * BufferedOutputStream：默认缓冲数组为8kb（8192byte）
     * 1.当缓冲区满的时候会写
     * 2.调用flush（）方法
     *
     */
    public static void test05() {
        try {
            OutputStream out = new FileOutputStream("D:\\1.txt");
            BufferedOutputStream bos = new BufferedOutputStream(out);
            for (int i = 0; i < 8193; i++) {
                bos.write(97);
            }
            System.out.println("over");
            bos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 字节数组复制文件经典写法
     *
     */
    public static void test04() {
        try {
            InputStream in = new FileInputStream("D:\\FeiQ.exe");
            OutputStream out = new FileOutputStream("D:\\111.exe");
            byte[] b = new byte[2048];
            int len;
            while ((len = in.read(b)) != -1) {
                out.write(b, 0, len);
            }
            System.out.println("copy over!!!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 单字节复制文件的经典写法
     *
     */
    public static void test03() {
        try {
            InputStream in = new FileInputStream("D:\\FeiQ.exe");
            OutputStream out = new FileOutputStream("D:\\1.exe");
            int len;
            while ((len = in.read()) != -1) {
                out.write(len);
            }
            System.out.println("copy over!!!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
