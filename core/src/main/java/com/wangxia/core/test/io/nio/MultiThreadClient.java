package com.wangxia.core.test.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class MultiThreadClient {
    public static void main(String[] args) throws IOException {
        SocketChannel sc = SocketChannel.open();
        sc.configureBlocking(false);
        sc.connect(new InetSocketAddress("127.0.0.1", 8008));
        while (!sc.finishConnect()){
            System.out.println("连接中...");
        }
        System.out.println("连接成功.");
        sc.write(Charset.defaultCharset().encode("123"));
        System.in.read();
    }
}
