package other.JAVA._00String;

public class testStringIntern {
    public static void main(String[] args) {
//        test1();
        test3();
    }

    public static void test1(){
        String s = "www.mio4.com";
        System.out.println(s.intern());
    }

    public static void test2(){
        String s = new String("1") + new String("2");
        System.out.println(s.intern() == s);
    }

    public static void test3(){
        String str1 = "a";
        String str2 = "b";
        String str3 = "ab";
        String str4 = str1 + str2;
        String str5 = new String("ab");

        System.out.println(str5.equals(str3)); //true
        System.out.println(str5 == str3); //false
        System.out.println(str5.intern() == str3); //true
        System.out.println(str5.intern() == str4); //false
        System.out.println(str5.intern() == str4.intern()); //true
    }
}
