package XiaoZhao.ClassLoading;

class SuperClass{

    static{
        System.out.println("SuperClass Init");
    }

    public static int value = 100;
}

class SubClass extends SuperClass{

    static{
        System.out.println("SubClass Init");
    }
}

class ConstClass{

    static{
        System.out.println("ConstClass Init");
    }

    public static final String HELLOWORLD = "hello,world!"; //进入常量池，不会触发类初始化
}

public class NotInitialization {

    public static void main(String[] args){
        System.out.println(SubClass.value); //只有父类会被初始化
        SuperClass[] sca = new SuperClass[10]; //父类不会被初始化

        System.out.println(ConstClass.HELLOWORLD);
    }
}
