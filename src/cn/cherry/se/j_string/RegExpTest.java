/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.j_string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式
 *
 * @author Leon
 * @version 2018/5/4 14:20
 */
public class RegExpTest {

    public static void main(String[] args) {
        String str = "yin gh hy er error we are";
        String reg = "\\b[a-z]{1,3}\\b";
        Pattern pattern = Pattern.compile(reg);
        Matcher m = pattern.matcher(str);
        System.out.println(pattern);
        System.out.println(m.matches());
    }

    public static boolean test01(String str){
        return str.matches("^(A-Z){1}\\w*。$");
    }
}
