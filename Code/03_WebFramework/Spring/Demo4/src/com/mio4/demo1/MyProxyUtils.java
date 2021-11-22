package com.mio4.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK 代理
 */
public class MyProxyUtils {
    public static UserDao getProxy(final UserDao dao){
        return (UserDao) Proxy.newProxyInstance(dao.getClass().getClassLoader(), dao.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if("save".equals(method.getName()))
                    System.out.println("save method~");
                else if("update".equals(method.getName()))
                    System.out.println("update method~");
                return method.invoke(dao,args);
                //System.out.println("invoke~");
                //return null;
            }
        });
    }
}
