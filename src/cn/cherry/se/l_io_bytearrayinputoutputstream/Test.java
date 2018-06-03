/**
 * Copyright © 2018, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.l_io_bytearrayinputoutputstream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/6/3 20:56
 */
public class Test {

    public static void main(String[] args) throws Exception{
        // output();
        input();
    }



    public static void input() {
        try {
            byte[] srcArr = new byte[100];
            for (int i = 0; i < 100; i++) {
                srcArr[i] = (byte)i;
            }
            ByteArrayInputStream bais = new ByteArrayInputStream(srcArr);

            /*byte[] readArr = new byte[5];
            // int read = bais.read();
            bais.read(readArr, 0 , readArr.length);
            System.out.println(readArr);*/
            bais.mark(22);
            bais.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void output() {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            // baos.write(111);
            /*byte[] arr = new byte[1000];
            for (int i = 0; i < 1000; i++) {
                arr[i] = (byte)i;
            }
            baos.write(arr, 0 ,arr.length);*/
            // baos.writeTo();
            // baos.write(97);
            // baos.write(111);
            // String s = baos.toString();
            // System.out.println(s);
            // baos.size();
            baos.reset();
            baos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
