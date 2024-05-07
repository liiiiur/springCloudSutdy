package com.wangxia.core.test.multithreading;

public class ThreadMain {
    public static void main(String[] args) {
        new Thread(Task::run,"t1").start();
        new Thread(Task::run,"t2").start();
        new Thread(Task::run,"t3").start();
    }
}
