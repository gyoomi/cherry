/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.l_io_bufferedinputoutstream;


import java.io.*;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/6/4 9:32
 */
public class Test {

    public static void main(String[] args) {
        // read();
        // read111();
        write();
    }

    public static void write() {
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("d:\\2.txt"));
            byte[] arr = new byte[100];
            for (int i = 0; i < 100; i++) {
                arr[i] = (byte) i;
            }
            bos.write(arr, 0, arr.length);
            bos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void read111() {
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream("d:\\1.txt"));
            byte[] readArr = new byte[8];
            int len;
            while ((len = bis.read(readArr, 0 , 8)) != -1) {
                for (int i = 0; i < len; i++) {
                    System.out.println(readArr[i]);
                }
                System.out.println("----------------------");
            }
            bis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void read() {
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream("d:\\1.txt"));
            int len;
            while ((len = bis.read()) != -1) {
                System.out.println(len);
            }
            bis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
