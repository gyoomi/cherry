/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.q_netty_marshalling;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/7/12 10:17
 */
public class SubReqClientHandler extends ChannelHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Request r1 = new Request("555");
        Request r2 = new Request("666");
        Request r3 = new Request("777");
        Request r4 = new Request("888");
        ctx.writeAndFlush(r1);
        ctx.writeAndFlush(r2);
        ctx.writeAndFlush(r3);
        Thread.sleep(2000);
        ctx.writeAndFlush(r4);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            Response rs = (Response) msg;
            System.out.println("The client received is : " + rs);
        } finally {
            // 释放资源
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
