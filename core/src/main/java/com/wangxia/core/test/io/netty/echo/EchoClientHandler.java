package com.wangxia.core.test.io.netty.echo;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Scanner;

public class EchoClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        new Thread(()->{
            Scanner scanner = new Scanner(System.in);
            while(true){
                System.out.println("Enter your message:");
                String line = scanner.nextLine();
                if ("exit".equalsIgnoreCase(line)){
                    ctx.close();
                    break;
                }
                ctx.writeAndFlush(line);
            }
        },"echoClientHandler").start();
        ctx.writeAndFlush("client connected");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("client received: " + msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
