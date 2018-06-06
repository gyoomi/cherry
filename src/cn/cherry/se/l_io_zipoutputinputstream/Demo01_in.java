/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.l_io_zipoutputinputstream;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
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
        ArrayList<String> allFileName = new ArrayList<String>();
        File file = new File("d:\\test.zip");
        File outFile = null;
        ZipFile zipFile = new ZipFile(file);
        ZipEntry entry = null;
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(file));

        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            entry = entries.nextElement();
            File zFile = new File("d:\\" + entry.getName());
            File fPath = new File(zFile.getParentFile().getPath());
            if (entry.isDirectory()) {
                if (!zFile.exists()) {
                    zFile.mkdirs();
                }
                zipInputStream.closeEntry();
            } else {
                if (!fPath.exists()) {
                    fPath.mkdirs();
                }
                FileOutputStream fos = new FileOutputStream(zFile);
                int len;
                allFileName.add(zFile.getAbsolutePath());
                while ((len = zipInputStream.read()) != -1) {
                    fos.write(len);
                }
                fos.close();
                zipInputStream.closeEntry();
            }
        }

        zipInputStream.close();
        System.out.println("over");
        System.out.println(allFileName);
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
