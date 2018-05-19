/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.l_io_file;

import java.io.File;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/5/19 10:34
 */
public class FileTest_01 {

    public static void main(String[] args) {
        File file = new File("D:\\");
        // System.out.println(file);
        // System.out.println(file.toString());
        // System.out.println(file.isDirectory());
        // System.out.println(file.isFile());
        // System.out.println(file.getParent());
        // System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());
    }

}
