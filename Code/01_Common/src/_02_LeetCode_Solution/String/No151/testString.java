package _02_LeetCode_Solution.String.No151;

import org.junit.Test;

public class testString {

    @Test
    public void test1(){
        String s = " 1 2 3 ";
        System.out.println(s.trim());
        System.out.println(s);
    }

    @Test
    public void test2(){
        String s = " 1       2  3 4 ";
        String s2 = s.replaceAll("\\s+ "," ");
        System.out.println(s2);
    }
}
