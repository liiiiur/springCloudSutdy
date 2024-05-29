package com.wangxia.core.test.proxy;

import java.lang.reflect.Proxy;

public class ProxyMain {
    public static void main(String[] args) {
        OldProxy test = new OldProxy("测试", 18);
        ProxyInterface proxy = (ProxyInterface) Proxy.newProxyInstance(ProxyInterface.class.getClassLoader(), new Class<?>[]{ProxyInterface.class}, new NewProxy(test));
        proxy.save(test);
    }
}
