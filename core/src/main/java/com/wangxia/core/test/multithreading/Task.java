package com.wangxia.core.test.multithreading;

public class Task {

    private static int count=0;

    public static synchronized

    void run(){
        while (count<100){
            System.out.println(++count);
        }
    }
}
