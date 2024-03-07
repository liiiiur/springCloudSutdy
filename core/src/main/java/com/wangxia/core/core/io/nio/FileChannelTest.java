package com.wangxia.core.core.io.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {
    public static void main(String[] args) {
        try (FileChannel channel = new FileInputStream("core/src/main/resources/doc/io测试.txt").getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(10);//堆内存，读写效率低，受GC影响
            ByteBuffer directBuffer = ByteBuffer.allocateDirect(16);//直接内存，读写效不受率高(少一次拷贝)，不受GC影响，分配效率低
            while (true) {
                int data = channel.read(buffer);
                //buffer.put("a".getBytes())
                if (data == -1) break;
                buffer.flip();//读模式
                while (buffer.hasRemaining()) {
                    System.out.println((char) buffer.get());
                    //int write = channel.write(buffer);
                }
                buffer.clear();
            }
        } catch (IOException e) {
        }
    }
}
