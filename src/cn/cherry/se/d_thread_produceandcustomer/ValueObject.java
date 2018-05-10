/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_produceandcustomer;

/**
 * 既然生产者/消费者模型有一个缓冲区，那么我们就自己做一个缓冲区，生产者和消费者的通信都是通过这个缓冲区的。value为""表示缓冲区空，value不为""表示缓冲区满：
 *
 * @author Leon
 * @version 2018/5/9 17:28
 */
public class ValueObject {

    public static String value = "";
}
