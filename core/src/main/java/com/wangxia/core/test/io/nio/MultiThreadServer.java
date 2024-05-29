package com.wangxia.core.test.io.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class MultiThreadServer {
    public static void main(String[] args) throws IOException {
        Thread.currentThread().setName("boos");
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress("127.0.0.1",8008));
        ssc.configureBlocking(false);
        Selector boos = Selector.open();
        ssc.register(boos, SelectionKey.OP_ACCEPT);
        int cpuCount = Runtime.getRuntime().availableProcessors();
        Work[] work = new Work[cpuCount];
        log.debug("{} CPU", cpuCount);
        for (int i = 0; i < work.length; i++) {
            work[i]=new Work("work-"+i);
        }
        AtomicInteger atomicInteger = new AtomicInteger();
        while (true){
            boos.select();
            Iterator<SelectionKey> iterator = boos.selectedKeys().iterator();
            if(iterator.hasNext()){
                SelectionKey key = iterator.next();
                iterator.remove();
                if(key.isAcceptable()){
                    SocketChannel sc = ssc.accept();
                    sc.configureBlocking(false);
                    work[atomicInteger.getAndIncrement()% work.length].register(sc);
                }
            }
        }
    }

    static class Work extends Thread{
        private Thread thread;
        private Selector selector;
        private String name;
        private Boolean isStart=false;

        public Work(String name){
            this.name=name;
        }

        public void register(SocketChannel sc) throws IOException {
            if(!isStart){
                selector=Selector.open();
                thread=new Thread(this,name);
                thread.start();
                isStart=true;
            }
            selector.wakeup();
            sc.register(selector,SelectionKey.OP_READ);
        }

        @Override
        public void run() {
            while (true){
                try {
                    selector.select();
                    Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
                    while (iter.hasNext()){
                        SelectionKey key = iter.next();
                        iter.remove();
                        if (key.isReadable()) {
                            log.debug("reading...{}",key);
                            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                            SocketChannel clientChannel = (SocketChannel) key.channel();
                            clientChannel.read(byteBuffer);
                            byteBuffer.flip();
                            System.out.println("测试读取");
                            System.out.println(Charset.defaultCharset().decode(byteBuffer).toString());
                            sleep(1000);
                        }else if (key.isWritable()) {
                            log.debug("writing...{}",key);
                            sleep(1000);
                        }else {
                            log.debug("not read..{}",key);
                            sleep(1000);
                        }
                    }
                } catch (IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
