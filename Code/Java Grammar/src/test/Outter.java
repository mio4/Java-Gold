package test;

public class Outter {
    private int num;
    public static class Inner{
        void print(){
            System.out.println("inner");
        }
    }

    public class Inner2{
        void print(){
            System.out.println("inner2");
        }
    }

    public static void main(String[] args){
        Outter.Inner inner = new Inner();
        inner.print();
        Outter.Inner2 inner2 = new Outter().new Inner2();
        inner2.print();
    }
}
