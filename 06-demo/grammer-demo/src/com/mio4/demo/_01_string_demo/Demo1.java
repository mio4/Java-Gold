package com.mio4.demo._01_string_demo;

public class Demo1 {

    public static void main(String[] args) {
        //基本数据类型
        int num1 = 100;
        int num2 = 100;
        System.out.println("num1 == num2 : " + (num1 == num2) + "\n");

        //引用类型，其中'System.identityHashCode'可以理解为打印对象地址
        String str1 = "mio4";
        String str2 = "mio4";
        System.out.println("str1 address : " + System.identityHashCode(str1));
        System.out.println("str2 address : " + System.identityHashCode(str1));
        System.out.println("str1 == str2 : " + (str1 == str2) + "\n");

        String str3 = new String("mio4");
        String str4 = new String("mio4");
        System.out.println("str3 address : " + System.identityHashCode(str3));
        System.out.println("str4 address : " + System.identityHashCode(str4));
        System.out.println("str3 == str4 : " + (str3 == str4));
    }
}
