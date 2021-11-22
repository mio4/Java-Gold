package com.mio4.demo._01_string_demo;

public class Demo2 {

    public static void main(String[] args) {
        String str1 = "mio4";
        String str2 = "mio4";

        String str3 = new String("mio4");
        String str4 = new String("mio4");

        System.out.println("str1 address : " + System.identityHashCode(str1));
        System.out.println("str2 address : " + System.identityHashCode(str1));
        System.out.println("str1.equals(str2) : " + str1.equals(str2) + "\n");

        System.out.println("str3 address : " + System.identityHashCode(str3));
        System.out.println("str4 address : " + System.identityHashCode(str4));
        System.out.println("str3.equals(str4) : " + str3.equals(str4) + "\n");
    }
}
