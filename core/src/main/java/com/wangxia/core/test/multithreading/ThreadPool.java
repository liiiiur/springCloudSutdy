package com.wangxia.core.test.multithreading;

import java.util.concurrent.*;

public class ThreadPool {

    public static ExecutorService getFixedThreadpool(){
        return Executors.newFixedThreadPool(3);
    }

    public static ExecutorService getSingleThreadpool(){
        return Executors.newSingleThreadExecutor();
    }

    public static ExecutorService getThreadpool(){
        return Executors.newCachedThreadPool();
    }

    public static ThreadPoolExecutor getThreadPoolExecutor(){
        return new ThreadPoolExecutor(
                2,
                5,
                60L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10),
                new ThreadPoolExecutor.AbortPolicy()
        );
    }

}
