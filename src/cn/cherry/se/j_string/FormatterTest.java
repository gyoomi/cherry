/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.j_string;

import java.util.Formatter;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/5/4 13:54
 */
public class FormatterTest {
    public static void main(String[] args) {
        Formatter f = new Formatter();
        Formatter format = f.format("Row: [%d -> %f] ", 22, 22.33);
        String s = format.toString();
        System.out.println(s);
    }
}
