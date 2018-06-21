/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.l_nio_buffer;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/6/21 16:38
 */
public class Demo00 {

    public static void main(String[] args) throws Exception {
        test01();
    }

    /**
     * 视图缓冲区
     *
     * @throws Exception
     */
    public static void test01() throws Exception {
        ByteBuffer buffer = ByteBuffer.allocate(7);
        CharBuffer charBuffer = buffer.asCharBuffer();
        System.out.println(charBuffer.capacity());
    }
}
