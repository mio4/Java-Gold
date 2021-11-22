package XiaoZhao.ClassLoading;

class JVMParent {

    public static int width = 100;

    public static int count;

    {
        System.out.println("parent no static code block :" + count);
    }

    static{
        System.out.println("parent static's count:" + count);
    }

    JVMParent(int a){
        System.out.println("parent init one parameter");
    }

    JVMParent(){
        System.out.println("parent init");
    }

}

public class JVMSon extends JVMParent {


    {
        System.out.println("son no static code block :" + count);
    }

    static {
        System.out.println("son static 1");
    }

    public static int count1;


    JVMSon() {
        System.out.println("son init:" + count);
    }

    static {
        System.out.println("son static 2");
    }

    public static void main(String[] args) {
        System.out.println("son main start");
        JVMSon a = new JVMSon();

    }

}
