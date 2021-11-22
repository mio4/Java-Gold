package Others.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyDynamicProxy {
    public static void main(String[] args){
        HelloImpl hello = new HelloImpl();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(hello);
        Hello proxyHello = (Hello) Proxy.newProxyInstance(HelloImpl.class.getClassLoader(),HelloImpl.class.getInterfaces(),myInvocationHandler);
        proxyHello.sayHello();
    }
}

interface Hello{
    void sayHello();
}

class HelloImpl implements Hello{

    @Override
    public void sayHello() {
        System.out.println("Say Hello");
    }
}

class MyInvocationHandler implements InvocationHandler{
    private Object target;

    public MyInvocationHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invocation say Hello");
        System.out.println("method " + method.getName() + " is invoked");
        Object result = method.invoke(target,args);
        return result;
    }
}
