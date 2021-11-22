package XiaoZhao.ClassLoading;

import org.junit.Test;

class ClassForName {

    //静态代码块
    static {
        System.out.println("执行了静态代码块");
    }
    //静态变量
    private static String staticFiled = staticMethod();

    //赋值静态变量的静态方法
    public static String staticMethod(){
        System.out.println("执行了静态方法");
        return "给静态字段赋值了";
    }
}

public class testClassForName {
    @Test
    public void test(){

        try {
            Class.forName("XiaoZhao.ClassLoading.ClassForName");
            System.out.println("#########分割符(上面是Class.forName的加载过程，下面是ClassLoader的加载过程)##########");
            ClassLoader.getSystemClassLoader().loadClass("XiaoZhao.ClassLoading.ClassForName");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
