package com.wangxia.core.test.designPattern.creationPatterns.singleton;

public class HungrySingleton {
    private static HungrySingleton instance=new HungrySingleton();
    private HungrySingleton() {}
    public static HungrySingleton getInstance(){
        return instance;
    }

}
