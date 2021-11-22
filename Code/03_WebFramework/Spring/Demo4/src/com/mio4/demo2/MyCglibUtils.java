package com.mio4.demo2;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


/**
 * Cglib 代理
 * @return
 */
public class MyCglibUtils {
    public static BookDaoImpl getProxy(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(BookDaoImpl.class); //设置父类
        enhancer.setCallback(new MethodInterceptor() { //设置回调函数
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                if("save".equals(method.getName()))
                    System.out.println("enhanced save~");
                else if("update".equals(method.getName()))
                    System.out.println("enhanced update~");
                return methodProxy.invokeSuper(o,args);
                //return null;
            }
        });
        return (BookDaoImpl) enhancer.create();
    }
}
