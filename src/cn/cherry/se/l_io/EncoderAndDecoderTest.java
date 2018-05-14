/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.l_io;

import java.util.Arrays;

/**
 * byte 是字节数据类型 ，是有符号型的，占1 个字节；大小范围为-128—127 。char 是字符数据类型 ，是无符号型的，占2字节(Unicode码 ）；
 * 大小范围 是0—65535 ；char是一个16位二进制的Unicode字符，JAVA用char来表示一个字符 。
 *
 * @author Leon
 * @version 2018/5/14 10:14
 */
public class EncoderAndDecoderTest {
    private static char c;
    public static void main(String[] args) throws Exception {
        System.out.println(c);
        System.out.println("--------------------");
        String str = "纞";
        byte[] bytes = str.getBytes("unicode");
        System.out.println(new String(bytes, "unicode"));
        /*byte[] bytes = str.getBytes("utf-8");
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }*/
    }

    /**
     * getBytes()默认是按照当前系统环境进行编码和解码
     *
     */
    public static void test01() {
        String str = "好";
        byte[] bytes = str.getBytes();
        System.out.println(Arrays.toString(bytes));
        String str2 = "A";
        byte[] bytes2 = str2.getBytes();
        System.out.println(Arrays.toString(bytes2));
        String str3 = "0";
        byte[] bytes3 = str3.getBytes();
        System.out.println(Arrays.toString(bytes3));
    }

    /**
     * 测试不同编码下的问价和解码和编码
     *
     * @throws Exception
     */
    public static void test02() throws Exception{
        String str = "好";
        byte[] b_utf8 = str.getBytes("UTF-8");
        byte[] b_gbks = str.getBytes("gbk");
        byte[] b_unicode = str.getBytes("unicode");
        // 编码错误
        byte[] b_iso = str.getBytes("iso8859-1");
        System.out.println(Arrays.toString(b_utf8));
        System.out.println(Arrays.toString(b_gbks));
        System.out.println(Arrays.toString(b_unicode));
        System.out.println(Arrays.toString(b_iso));
        System.out.println(new String(b_unicode, "unicode"));
        // 解码乱码
        System.out.println(new String(b_iso, "iso8859-1"));
        System.out.println("-----------------------------------------");
        String str1 = "a";
        byte[] b1_utf8 = str1.getBytes("UTF-8");
        byte[] b1_gbks = str1.getBytes("gbk");
        byte[] b1_unicode = str1.getBytes("unicode");
        System.out.println(Arrays.toString(b1_utf8));
        System.out.println(Arrays.toString(b1_gbks));
        System.out.println(Arrays.toString(b1_unicode));
    }
}
