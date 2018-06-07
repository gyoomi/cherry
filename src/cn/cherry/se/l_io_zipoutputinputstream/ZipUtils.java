/**
 * Copyright © 2018, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.l_io_zipoutputinputstream;

import java.io.*;
import java.util.zip.*;

/**
 * ZIP 解压缩工具包
 *
 * @author Leon
 * @version 2018/6/6 23:07
 */
public class ZipUtils {

    /**
     * Default buff byte size
     *
     */
    private static final int DEFAULT_BUFF_SIZE = 1024;

    /**
     * Default basedir value
     *
     */
    private static final boolean DEFAULT_DIR = false;

    public static void decompress(String srcPath) throws Exception {
        decompress(new File(srcPath));
    }

    public static void decompress(File srcFile) throws Exception {
        File baseFile = srcFile.getParentFile();
        decompress(srcFile, baseFile);
    }

    public static void decompress(String srcPath, String destPath) throws Exception {
        decompress(new File(srcPath), new File(destPath));
    }

    public static void decompress(File srcFile, File destFile) throws Exception {
        CheckedInputStream cis = new CheckedInputStream(new FileInputStream(srcFile), new CRC32());
        ZipInputStream zis = new ZipInputStream(cis);
        doDecompress(destFile, zis);
        zis.close();
    }

    private static void doDecompress(File destFile, ZipInputStream zis) throws Exception {
        ZipEntry zipEntry = null;
        while ((zipEntry = zis.getNextEntry()) != null) {
            String dir = destFile.getPath() + File.separator + zipEntry.getName();
            File dirFile = new File(dir);
            fileProber(dirFile);
            if (zipEntry.isDirectory()) {
                dirFile.mkdirs();
            } else {
                doDecompressFile(dirFile, zis);
            }
            zis.closeEntry();
        }
    }

    private static void doDecompressFile(File destFile, ZipInputStream zis) throws Exception {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
        int len;
        byte[] buff = new byte[DEFAULT_BUFF_SIZE];
        while ((len = zis.read(buff, 0 ,DEFAULT_BUFF_SIZE)) != -1) {
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

    public static void compress(String srcPath, String destPath,boolean dirFlag) throws Exception {
        compress(new File(srcPath), new File(destPath), dirFlag);
    }

    public static void compress(String srcPath, String destPath) throws Exception {
        compress(new File(srcPath), new File(destPath), DEFAULT_DIR);
    }

    public static void compress(File srcFile, File destFile, boolean dirFlag) throws Exception {
        compress(srcFile, new ZipOutputStream(new FileOutputStream(destFile)), dirFlag);
    }

    public static void compress(File srcFile, ZipOutputStream zos, boolean dirFlag) throws Exception {
        if (srcFile.isDirectory()) {
            if (dirFlag) {
                doCompress(zos, srcFile, srcFile.getName() + File.separator);
            } else {
                doCompress(zos, srcFile, "");
            }
        } else {
            doCompress(zos, srcFile, "");
        }
        zos.close();
    }

    public static void doCompress(ZipOutputStream zos, File file, String baseDir) throws Exception {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                doCompress(zos, files[i], baseDir);
            }
        } else {
            byte[] buff = new byte[DEFAULT_BUFF_SIZE];
            InputStream in = new FileInputStream(file);
            zos.putNextEntry(new ZipEntry(baseDir + File.separator + file.getName()));
            int len;
            while ((len = in.read(buff,0 ,DEFAULT_BUFF_SIZE)) != -1) {
                zos.write(buff, 0, len);
            }
            in.close();
        }
    }

}
