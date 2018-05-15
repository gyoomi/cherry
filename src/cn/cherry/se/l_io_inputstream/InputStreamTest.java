/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.l_io_inputstream;


import javax.sound.sampled.*;
import java.io.*;
/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/5/14 16:19
 */
public class InputStreamTest {

    public static void main(String[] args) throws Exception {
        test04();

    }

    public static void test05() {

    }
    /**
     * ByteArrayInputStream，主要是应对流的来源和目的地不一定是文件这种情况，比如说可能是内存，可能是数组。
     *
     */
    public static void test04() throws IOException {
        String str = "Hello World!哈";
        byte[] bytes = str.getBytes("utf-8");
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        try {
            OutputStream out = new FileOutputStream("D:\\11.txt");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
        }
        int len = 0;
        byte[] b = new byte[3];
        while ((len = bais.read(b)) != -1) {
            System.out.print(new String(b, 0, len));
        }
        try {
            bais.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * AudioInputStream的使用
     *
     */
    public static void test03() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("d:\\you.wav"));
            byte[] mp3s = getMp3(audioInputStream);
            InputStream in = new ByteArrayInputStream(mp3s);
            play(in, audioInputStream.getFormat());

        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }

    /**
     * 播放音频
     *
     * @param in
     * @param format
     */
    public static void play(InputStream in, AudioFormat format) {
        int bufferSize = format.getFrameSize() * Math.round(format.getSampleRate() / 10);
        byte[] buffer = new byte[bufferSize];
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
        try {
            SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
            line.open(format, bufferSize);
            line.start();
            int numBytesRead = 0;
            while (numBytesRead != -1) {
                numBytesRead = in.read(buffer, 0 ,buffer.length);
                if (numBytesRead != -1) {
                    line.write(buffer, 0 ,numBytesRead);
                }
            }
            line.drain();
            line.close();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }

    /**
     * 将音频输入流转换为字节数组
     *
     * @param stream
     * @return
     */
    public static byte[] getMp3(AudioInputStream stream) {
        int length = (int) (stream.getFormat().getFrameSize() * stream.getFrameLength());
        byte[] mp3s = new byte[length];
        DataInputStream dis = new DataInputStream(stream);
        try {
            dis.readFully(mp3s);
            System.out.println(length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mp3s;
    }

    /**
     * 2.FileInputStream的使用于读取文件内容。常用的有两种构造函数
     *
     */
    public static void test02() {
        try {
            File file = new File("d:\\1.txt");
            InputStream in = new FileInputStream(file);
            byte[] b = new byte[2];
            int len = 0;
            // in.read(b)返回此次读到的字节数
            while ((len = in.read(b)) != -1) {
                System.out.print(new String(b, 0, len));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }

    /**
     * 1.FileInputStream的使用于读取文件内容。常用的有两种构造函数
     *
     */
    public static void test01() {
        try {
            File file = new File("d:\\1.txt");
            InputStream in = new FileInputStream(file);
            int len;
            while ((len = in.read()) != -1) {
                System.out.print((char)len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
