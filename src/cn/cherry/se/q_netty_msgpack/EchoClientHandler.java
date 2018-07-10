/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.q_netty_msgpack;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/7/9 11:50
 */
public class EchoClientHandler extends ChannelHandlerAdapter {

    private final int sendNumber;

    public EchoClientHandler(int sendNumber) {
        this.sendNumber = sendNumber;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        UserInfo[] userInfos = userInfo();
        for (UserInfo userInfo : userInfos) {
            ctx.writeAndFlush(userInfo);
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("Client receive the msg: " + msg);
        // ctx.write(msg);
    }

    private UserInfo[] userInfo() {
        // 数组必须进行初始化操作
        UserInfo[] userInfos = new UserInfo[sendNumber];
        for (int i = 0; i < sendNumber; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setAge(i);
            userInfo.setName("ABCDEFG ---> " + i);
            userInfos[i] = userInfo;
        }
        return userInfos;
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

}
