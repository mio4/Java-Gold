package XiaoZhao.ClassLoading;

/**
 * 通过JVM类加载机制解释执行结果
 */
class Singleton{
    private static Singleton singleton = new Singleton();
    public static int value1;
    public static int value2 = 0;

    private Singleton(){
//        value1++;
//        value2++;
        value1 = value1 + 10;
        value2 = value2 + 10;
    }

    public static Singleton getInstance(){
        return singleton;
    }
}

class Singleton2{
    public static int value1;
    public static int value2 = 0;
    private static Singleton2 singleton2 = new Singleton2();

    private Singleton2(){
        value1++;
        value2++;
    }

    public static Singleton2 getInstance2(){
        return singleton2;
    }
}

public class testClassLoad {

    public static void main(String[] args){
        Singleton singleton = Singleton.getInstance();
        System.out.println("Singleton1 value1:" + singleton.value1);
        System.out.println("Singleton1 value2:" + singleton.value2); // 0 not 1

        Singleton2 singleton2 = Singleton2.getInstance2();
        System.out.println("Singleton2 value1:" + singleton2.value1);
        System.out.println("Singleton2 value2:" + singleton2.value2);
    }
}
