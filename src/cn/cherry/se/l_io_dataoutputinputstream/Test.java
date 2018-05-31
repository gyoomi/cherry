/**
 * Copyright © 2018, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.l_io_dataoutputinputstream;

import java.io.*;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/5/31 22:21
 */
public class Test {

    public static void main(String[] args) {
        write();
        // read();
    }

    public static void write() {
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("d:\\1.txt"));
            // dos.write(65);
            // dos.writeByte(126);
            // dos.writeShort(1300);
            // dos.writeInt(9999);
            // dos.writeLong(1000000L);
            dos.writeBoolean(true);
            dos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void read() {
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream("d:\\1.txt"));
            // short s = dis.readShort();
            long l = dis.readLong();
            dis.close();
            System.out.println(l);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
