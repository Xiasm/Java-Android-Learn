package com.xsm.androidexperience.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Author: 夏胜明
 * Date: 2018/10/8 0008
 * Email: xiasem@163.com
 * Description:
 */
public class DynamicProxy implements InvocationHandler {
    //被代理的对象
    private Object target;

    public DynamicProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("start work");
        Object result = method.invoke(target, objects);
        System.out.println("end work");
        return result;
    }
}
