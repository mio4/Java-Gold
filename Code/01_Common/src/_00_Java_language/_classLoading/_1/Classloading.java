package _00_Java_language._classLoading._1;

class Grandpa
{
    static
    {
        System.out.println("爷爷在静态代码块");
    }
}
class Father extends Grandpa
{
    static
    {
        System.out.println("爸爸在静态代码块");
    }

    public static int factor = 25;

    public Father()
    {
        System.out.println("我是爸爸~");
    }
}
class Son extends Father
{
    static
    {
        System.out.println("儿子在静态代码块");
    }

    public Son()
    {
        System.out.println("我是儿子~");
    }
}
public class Classloading {
    public static void main(String[] args)
    {
        System.out.println("爸爸的岁数:" + Son.factor);  //入口
    }
}
