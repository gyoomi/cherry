/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.j_string;

/**
 * String 方法使用
 *
 * @author Leon
 * @version 2018/5/4 11:32
 */
public class Methods {
    public static void main(String[] args) {
        String str = "hello String!";
        char[] chars = str.toCharArray();
        char c = str.charAt(3);
        byte[] bytes = str.getBytes();
        "java".getChars(0, "java".length(), chars,3);
        boolean b1 = str.contains("Str");
        String t = "hel";
        // 当某个字符串调用该方法时，表示从当前字符串的firstStart位置开始，取一个长度为len的子串；然后从另一个字符串other的
        // otherStart位置开始也取一个长度为len的子串，然后比较这两个子串是否相同，如果这两个子串相同则返回true，否则返回false。
        boolean b = t.regionMatches(0, str, 2, 2);
        // 是否忽略大小写
        boolean b2 = t.regionMatches(true, 0, str, 2, 2);
        String sub = str.substring(0, str.length()-1);
        String tStr = str.concat("哈哈");
        System.out.printf("Row1: [%d  %f]", 99, 98.24324);

    }
}
