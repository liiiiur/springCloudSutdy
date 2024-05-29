package com.wangxia.core.test.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class ReadClient {
    public static void main(String[] args) throws IOException {
        SocketChannel sc = SocketChannel.open();
        sc.connect(new InetSocketAddress("127.0.0.1",8008));
        while (true){
            ByteBuffer buffer = ByteBuffer.allocate(1024 * 1024);
            int read = sc.read(buffer);
            System.out.println(read);
            buffer.clear();
        }
    }
}
