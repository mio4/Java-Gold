package XiaoZhao.ClassLoading;

public class FieldResolution {


    interface interface0{
        int A = 0;
    }

    interface interface1 extends interface0{
        int A = 0;
    }

    interface interface2{
        int A = 2;
    }

    static class Parent implements interface1{
        public static int A = 3;
    }

    static class Sub extends Parent implements interface2{
        public static int A = 4;
    }

    public static void main(String[] args){
        System.out.println(Sub.A);
    }
}
