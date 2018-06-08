/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.l_io_bufferedwriterandreader;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/6/8 15:07
 */
public class Test {

    public static void main(String[] args) throws Exception {
        write01();
    }

    public static void write01() throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter("d:\\1.txt"), 8);
        bw.write("床前明月光，疑是地上霜。");
        bw.newLine();
        bw.write("hello java nio");
        bw.close();
    }
}
