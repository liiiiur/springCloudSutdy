package com.wangxia.core.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class NewProxy implements InvocationHandler{

    private Object target;

    public NewProxy(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("save")){
            System.out.println("save proxy");
            method.invoke(target,args);
        }else if(method.getName().equals("update")){
            System.out.println("update proxy");
            method.invoke(target,args);
        }
        return "test";
    }
}
