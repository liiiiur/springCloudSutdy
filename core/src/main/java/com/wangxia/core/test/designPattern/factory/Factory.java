package com.wangxia.core.test.designPattern.factory;

public class Factory {
    public Factory() {}

    public IMethod method(String methodName) {
        if (methodName.equals("method1")) {
            return new Method1();
        }else if (methodName.equals("method2")) {
            return new Method2();
        }
        return null;
    }
}
