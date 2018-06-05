/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.l_io_zipoutputinputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/6/5 9:40
 */
public class Demo00_out {

    public static void main(String[] args) throws Exception {
        zipMultiFile("D:\\solr", "D:\\solr.zip", true);
        System.out.println("over");
    }


    public static void zipMultiFile(String filePath, String zipPath, boolean dirFlag) throws Exception {
        File file = new File(filePath);
        File zipFile = new File(zipPath);
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile));
        if (file.isDirectory()) {
            if (dirFlag) {
                recursionZip(zos, file, file.getName() + File.separator);
            } else {
                recursionZip(zos, file, "");
            }
        } else {
            recursionZip(zos, file, "");
        }
        zos.close();
    }

    public static void recursionZip(ZipOutputStream zos, File file, String baseDir) throws Exception {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i <files.length; i++) {
                recursionZip(zos, files[i], baseDir + file.getName() + File.separator);
            }
        } else {
            // 递归程序出口
            byte[] buf = new byte[1024 * 8];
            InputStream in = new FileInputStream(file);
            zos.putNextEntry(new ZipEntry(baseDir + file.getName()));
            int len;
            while ((len = in.read(buf)) != -1) {
                zos.write(buf, 0, len);
            }
            in.close();
        }
    }

    /**
     * 单文件夹多文件压缩
     *
     * @throws Exception
     */
    public static void out02() throws Exception {
        File file = new File("d:" + File.separator + "test");
        File zipFile = new File("d:" + File.separator + "many.zip");
        InputStream in = null;
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile));
        int len;
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                in = new FileInputStream(files[i]);
                zos.putNextEntry(new ZipEntry(file.getName() + File.separator + files[i].getName()));
                while ((len = in.read()) != -1) {
                    zos.write(len);
                }
                in.close();
            }
        }
        zos.close();
        System.out.println("over");
    }

    /**
     * 单文件压缩
     *
     */
    public static void out01() throws Exception {
        File file = new File("d:" + File.separator + "1.txt");
        // 设置压缩文件名称
        File zipFile = new File("d:" + File.separator + "test.zip");
        InputStream in = new FileInputStream(file);
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile));
        zos.putNextEntry(new ZipEntry(file.getName()));
        zos.setComment("测试压缩输出流");
        int len;
        while ((len = in.read()) != -1) {
            zos.write(len);
        }
        zos.close();
        in.close();
        System.out.println("over");
    }
}
