package com.wangxia.core.test.io.netty.eventLoop;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.util.NettyRuntime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class TestEventLoop {
    private static final Logger log = LoggerFactory.getLogger(TestEventLoop.class);

    public static void main(String[] args) {
        EventLoopGroup group = new NioEventLoopGroup();
        System.out.println(NettyRuntime.availableProcessors());

        group.next().submit(()->{
            log.debug("测试");
        });

        group.next().scheduleAtFixedRate(()->{
            log.debug("这是定时任务");
        },1,1, TimeUnit.SECONDS);

        log.debug("main ");
    }
}
