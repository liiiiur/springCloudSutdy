package com.wangxia.core.test.io.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

@Slf4j
public class TransferFile {
    public static void main(String[] args) throws IOException {
        File file = new File("core/src/main/resources/doc/io测试.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel inputStreamChannel = fileInputStream.getChannel();
        FileOutputStream fileOutputStream = new FileOutputStream("core/src/main/resources/doc/io写入测试.txt");
        FileChannel fileOutputStreamChannel = fileOutputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate((int) file.length());
        inputStreamChannel.transferTo(0,buffer.limit(),fileOutputStreamChannel);
        fileInputStream.close();
        inputStreamChannel.close();
        fileOutputStream.close();
        fileOutputStreamChannel.close();
    }
}
