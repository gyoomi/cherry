/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.l_io_bufferedwriterandreader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/6/8 15:07
 */
public class Test {

    public static void main(String[] args) throws Exception {
        read01();
    }


    public static void read01() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("d:\\1.txt"));
        String s = br.readLine();
        System.out.println(s);
        br.close();
    }

    public static void write01() throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter("d:\\1.txt"), 8);
        char[] srcArr = new char[12];
        srcArr[0] = '我';
        srcArr[1] = '是';
        srcArr[2] = '天';
        srcArr[3] = '才';
        bw.write(srcArr, 0 , srcArr.length);
        bw.close();
    }

}
