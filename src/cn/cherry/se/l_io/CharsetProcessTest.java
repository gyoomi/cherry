/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.l_io;

import java.io.UnsupportedEncodingException;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/5/14 11:44
 */
public class CharsetProcessTest {

    public static void main(String[] args) {
        encode();
    }


    public static void encode() {
        String name = "I am 君山";
        try {
            byte[] iso8859 = name.getBytes("iso-8859-1");
            byte[] gb2312 = name.getBytes("gb2312");
            byte[] gbk = name.getBytes("gbk");
            byte[] utf8 = name.getBytes("utf-8");
            byte[] utf16 = name.getBytes("utf-16");
            System.out.println((char)22861);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
