/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.l_io_zipoutputinputstream;

import java.io.File;
import java.util.zip.ZipFile;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/6/5 11:10
 */
public class Demo01_in {

    public static void main(String[] args) throws Exception {

    }


    public static void in02() throws Exception {
        ZipFile zipFile = new ZipFile(new File("d:" + File.separator + ""));
    }

    public static void in01() throws Exception {
        File file = new File("d:" + File.separator + "jar-test.zip");
        ZipFile zipFile = new ZipFile(file);
        System.out.println(zipFile.getName());
    }
}
