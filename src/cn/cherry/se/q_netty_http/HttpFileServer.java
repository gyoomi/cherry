/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.q_netty_http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/7/12 15:58
 */
public class HttpFileServer {

    private static final String DEFAULT_URL = "/src/cn/cherry/se";

    public void run(final String url, final int port) throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            // Http请求消息解析器
                            ch.pipeline().addLast("http decoder", new HttpRequestDecoder());
                            // 将多个消息转为单个的FullHttpRequest/FullHttpResponse,原因是HTTP解码器在每个消息中生成多个消息对象
                            ch.pipeline().addLast("http aggregator", new HttpObjectAggregator(65536));
                            // 对相应消息进行编码
                            ch.pipeline().addLast("http encoder", new HttpResponseEncoder());
                            // 主要作用是支持异步发送的大码流（如大的文件传输），但是不占用过多的内存,防止内存溢出
                            ch.pipeline().addLast("http chucked", new ChunkedWriteHandler());
                            ch.pipeline().addLast("fileServerHandler", new HttpFileServerHandler(url));
                        }
                    });
            ChannelFuture f = b.bind("localhost", port).sync();
            System.out.println("The file http server started successful. the web site is : http://localhost:" + port + url);
            f.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        new HttpFileServer().run(DEFAULT_URL, 8090);
    }
}
