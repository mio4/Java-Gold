package test;

import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class test {

    @Test
    public void test1(){
        char c = '中';
        System.out.println(c);
    }

    @Test
    public void test2(){
        String s = "123456";
        //System.out.println(s.substring(1));
        System.out.println(reverseString(s));
    }

    public static String reverseString(String s){
        if(s == null || s.length() <= 1)
            return s;
        return reverseString(s.substring(1)) + s.charAt(0);
    }

    @Test
    public void test3() throws UnsupportedEncodingException {
        String s1 = "你好";
        String s2 = new String(s1.getBytes("GB2312"),"UTF-8");
        System.out.println(s2);
    }

    public static void main(String[] args){
        main(null);
    }

    @Test
    public void test4() throws IOException{
        try{
            Thread.sleep(1000);
        } catch (Exception e){
            e.printStackTrace();
            throw new IOException();
        }
    }
}
