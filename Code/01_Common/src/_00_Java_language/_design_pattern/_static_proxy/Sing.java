package _00_Java_language._design_pattern._static_proxy;

public class Sing implements IDoSomething{

    @Override
    public int doSomething(int num) {
        System.out.println("num" + num);
        return num;
    }
}
