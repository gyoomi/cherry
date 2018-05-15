/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.l_io_inputstream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 在java中，PipedOutputStream和PipedInputStream分别是管道输出流和管道输入流。
 * 它们的作用是让多线程可以通过管道进行线程间的通讯。在使用管道通信时，必须将PipedOutputStream和PipedInputStream配套使用。
 * 使用管道通信时，大致的流程是：
 *     1.我们在线程A中向PipedOutputStream中写入数据，这些数据会自动的发送到与PipedOutputStream对应的PipedInputStream中，进而存储在PipedInputStream的缓冲中；
 *     2.此时，线程B通过读取PipedInputStream中的数据。就可以实现，线程A和线程B的通信。
 *
 * @author Leon
 * @version 2018/5/15 10:44
 */
public class PipedInputStreamAndPipedOutputStream {

    class Send implements Runnable {

        private PipedOutputStream pos = null;

        public Send() {
            this.pos = new PipedOutputStream();
        }

        public PipedOutputStream getPipedOutputStream() {
            return this.pos;
        }

        @Override
        public void run() {
            String str = "Hello World!哈哈";
            try {
                this.pos.write(str.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                this.pos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    class Receive implements Runnable {

        private PipedInputStream pis = null;

        public Receive() {
            this.pis = new PipedInputStream();
        }

        public PipedInputStream getPipedInputStream() {
            return this.pis;
        }

        @Override
        public void run() {
            byte[] b = new byte[2048];
            int len = 0;
            try {
                len = this.pis.read(b);
                System.out.println("接受的内容是：" + new String(b, 0 ,len));
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                this.pis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        PipedInputStreamAndPipedOutputStream pp = new PipedInputStreamAndPipedOutputStream();
        pp.test01();
    }

    public void test01() throws IOException {
        Send s = new Send();
        Receive r = new Receive();
        s.getPipedOutputStream().connect(r.getPipedInputStream());
        new Thread(s).start();
        new Thread(r).start();
    }

}
