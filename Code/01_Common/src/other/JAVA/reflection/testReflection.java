package other.JAVA.reflection;

import java.lang.reflect.Method;

public class testReflection {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clz = Class.forName("other.JAVA.reflection.Student");
        Method[] methods = clz.getMethods();
        for(Method method : methods){
            System.out.println("方法名： " + method.getName());
        }
    }
}
