package Others.DynamicProxy;

public class ReflectionDemo {
    public static void main(String[] args){
        Class clazz = "Foo".getClass();
        System.out.println(clazz);
        Foo foo = new Foo();
        clazz = foo.getClass();
        System.out.println(clazz);
        //clazz = System.console().getClass();
        //System.out.println(clazz);
    }
}

class Foo{
    public Foo(){

    }


}
