/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.l_io_checkedinoutputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/6/7 17:21
 */
public class Test {

    public static void main(String[] args) throws Exception {
        checkIn();
        // 222957957
        // checkOut();
    }

    public static void checkIn() throws Exception {
        FileInputStream in = new FileInputStream("d:\\1.txt");
        CheckedInputStream cis = new CheckedInputStream(in, new CRC32());
        byte[] arr = new byte[1024*8];
        while ((cis.read(arr)) != -1) {}
        in.close();
        cis.close();
        System.out.println(cis.getChecksum().getValue());
    }

    public static void checkOut() throws Exception {
        OutputStream out = new FileOutputStream("d:\\1.txt");
        CheckedOutputStream cos = new CheckedOutputStream(out, new CRC32());
        String str = "hello world";
        cos.write(str.getBytes(), 0, str.length());
        out.close();
        cos.close();
        System.out.println(cos.getChecksum().getValue());
    }
}
