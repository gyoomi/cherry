/**
 * Copyright © 2018, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.l_io_zipoutputinputstream;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * ZIP 解压缩工具包
 *
 * @author Leon
 * @version 2018/6/6 23:07
 */
public class ZipUtils {

    public static void decompress(File srcFile, File destFile) throws Exception {
        CheckedInputStream cis = new CheckedInputStream(new FileInputStream(srcFile), new CRC32());
        ZipInputStream zis = new ZipInputStream(cis);
        doCompress(destFile, zis);
        zis.close();
    }

    private static void doCompress(File destFile, ZipInputStream zis) throws Exception {
        ZipEntry zipEntry = null;
        while ((zipEntry = zis.getNextEntry()) != null) {
            String dir = destFile.getPath() + File.separator + zipEntry.getName();
            File dirFile = new File(dir);
            fileProber(dirFile);
            if (zipEntry.isDirectory()) {
                dirFile.mkdirs();
            } else {
                doCompressFile(dirFile, zis);
            }
            zis.closeEntry();
        }
    }

    public static void doCompressFile(File destFile, ZipInputStream zis) throws Exception {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
        int len;
        byte[] buff = new byte[1024];
        while ((len = zis.read(buff, 0 ,1024)) != -1) {
            bos.write(buff, 0, len);
        }
        bos.close();
    }

    /**
     * 文件探测
     *
     * When the parent file not exist.Create it.
     *
     * @param dirFile
     * @throws Exception
     */
    public static void fileProber(File dirFile) throws Exception {
        File parentFile = dirFile.getParentFile();
        if (!parentFile.exists()) {
            fileProber(parentFile);
            parentFile.mkdirs();
        }
    }

    public static void main(String[] args) throws Exception {
        decompress(new File("D://test.zip"), new File("d:\\"));
    }
}
