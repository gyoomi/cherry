/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.q_netty_msgpack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import org.msgpack.MessagePack;
import org.msgpack.type.Value;

import java.util.List;

/**
 * 解码器
 *
 * @author Leon
 * @version 2018/7/9 11:30
 */
public class MsgpackDecoder extends MessageToMessageDecoder<ByteBuf> {


    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf buf, List<Object> out) throws Exception {
        final byte[] array;
        final int length = buf.readableBytes();
        array = new byte[length];
        buf.getBytes(buf.readerIndex(), array, 0, length);
        MessagePack msgpack = new MessagePack();
        Value read = msgpack.read(array);
        out.add(read);
    }
}
