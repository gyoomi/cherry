/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.l_io_zipoutputinputstream;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/6/5 11:10
 */
public class Demo01_in {

    public static void main(String[] args) throws Exception {
        in05();
    }

    public static void in05() throws Exception {
        File file = new File("d:\\test.zip");
        File outFile = null;
        ZipFile zipFile = new ZipFile(file);
        ZipEntry entry = null;
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(file));

        InputStream in = null;
        OutputStream out = null;
        while ((entry = zipInputStream.getNextEntry()) != null) {
            outFile = new File("d:\\" + entry.getName());

                if (!outFile.getParentFile().exists()) {
                    outFile.getParentFile().mkdir();
                }

                if (!outFile.exists()) {
                    outFile.createNewFile();
                }

            in = zipFile.getInputStream(entry);
            out = new FileOutputStream(outFile);
            int len;
            while ((len = in.read()) != -1) {
                out.write(len);
            }
            in.close();
            out.close();
        }

        zipInputStream.close();
        System.out.println("over");

    }

    public static void in04() throws Exception {
        File zipFile = new File("d:\\test.zip");
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFile));
        ZipEntry nextEntry = zipInputStream.getNextEntry();
        System.out.println(nextEntry.getName());
        zipInputStream.close();
    }

    /**
     * 已知压缩文件名称进行的解压
     *
     * @throws Exception
     */
    public static void in03() throws Exception {
        File file = new File("D:\\1.zip");
        File outputFile = new File("d:\\unzip.txt");
        ZipFile zipFile = new ZipFile(file);
        ZipEntry entry = zipFile.getEntry("1.txt");
        OutputStream out = new FileOutputStream(outputFile);
        InputStream in = zipFile.getInputStream(entry);
        int len;
        while ((len = in.read()) != -1) {
            out.write(len);
        }
        in.close();
        out.close();
        System.out.println("over");
    }

    public static void in02() throws Exception {
        ZipFile zipFile = new ZipFile(new File("d:" + File.separator + ""));
    }

    public static void in01() throws Exception {
        File file = new File("d:" + File.separator + "solr.zip");
        ZipFile zipFile = new ZipFile(file);
        System.out.println(zipFile.getName());
    }
}
