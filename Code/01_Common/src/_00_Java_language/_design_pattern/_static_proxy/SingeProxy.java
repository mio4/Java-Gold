package _00_Java_language._design_pattern._static_proxy;

public class SingeProxy implements IDoSomething{

    private Sing sing = new Sing();

    @Override
    public int doSomething(int num) {
        System.out.println("do something before");
        int res = sing.doSomething(num);
        System.out.println("do something after");
        return res;
    }
}
