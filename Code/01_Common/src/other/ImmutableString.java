package other;

import java.util.HashSet;

public class ImmutableString {

    public static String appendStr(String s){
        s+="bbb";
        return s;
    }

    public static void main(String[] args){
        String s = new String("aaa");
        String ns = ImmutableString.appendStr(s);
        System.out.println("String aaa>>>" + s);

        HashSet<StringBuilder> hs = new HashSet<StringBuilder>();
        StringBuilder sb1 = new StringBuilder("aaa");
        StringBuilder sb2 = new StringBuilder("aaabbb");
        hs.add(sb1);
        hs.add(sb2);

        StringBuilder sb3 = sb1;
        sb3.append("bbb");
        System.out.println(hs);

    }
}
