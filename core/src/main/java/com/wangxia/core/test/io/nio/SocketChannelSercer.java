package com.wangxia.core.test.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;


public class SocketChannelSercer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 6666);
        serverSocketChannel.bind(address);
        ByteBuffer byteBuffer = ByteBuffer.allocate(16);
        while (true){
            SocketChannel socketChannel = serverSocketChannel.accept();
            while (socketChannel.read(byteBuffer)!=-1){
                System.out.println(new String(byteBuffer.array(), StandardCharsets.UTF_8));
                byteBuffer.clear();
            }
        }
    }
}
