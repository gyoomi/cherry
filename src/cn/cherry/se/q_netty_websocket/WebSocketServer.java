/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.q_netty_websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/7/18 17:16
 */
public class WebSocketServer {

    public void run(int port) throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup childrenGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, childrenGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            // 将请求或应答消息编码或解码为http消息
                            ch.pipeline().addLast("http codec", new HttpServerCodec());
                            // 将http消息的多个部分组合成一条完成的http消息
                            ch.pipeline().addLast("aggregator", new HttpObjectAggregator(65536));
                            // 向客户端发送html5文件，它主要用于支持浏览器和服务器之间的进行WebSocket通信
                            ch.pipeline().addLast("http chunked", new ChunkedWriteHandler());
                        }
                    });
            Channel ch = b.bind(port).sync().channel();
            System.out.println("Web Socket Server start in http://localhost:" + port + "/");
            ch.closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            childrenGroup.shutdownGracefully();
        }
    }
}
