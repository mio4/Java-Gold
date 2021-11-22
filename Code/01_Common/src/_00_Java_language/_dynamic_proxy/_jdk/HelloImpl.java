package _00_Java_language._dynamic_proxy._jdk;

public class HelloImpl implements IHello{
    @Override
    public void sayHello() {
        System.out.println("Hello world");
    }
}
