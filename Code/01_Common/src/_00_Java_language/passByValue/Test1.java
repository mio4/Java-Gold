package _00_Java_language.passByValue;

public class Test1 {

    public static void main(String[] args) {
        int n = 3;
        System.out.println("Before change, n = " + n);
        changeData(n);
        System.out.println("After changeData(n), n = " + n);

        Integer i = 3;
        System.out.println("before " + i);
        changeInteger(i);
        System.out.println("after " + i);
    }

    public static void changeInteger(Integer i){
        i = 10;
    }

    public static void changeData(int n){
        n = 10;
    }
}
