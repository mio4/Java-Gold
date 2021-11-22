package _00_Java_language.passByValue;

public class Test3 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Hello ");
        System.out.println("Before change, sb = " + sb);
        changeData(sb);
        System.out.println("After changeData(n), sb = " + sb);
    }

    public static void changeData(StringBuffer strBuf) {
        strBuf = new StringBuffer("Hi ");
        strBuf.append("World!");
    }
}
