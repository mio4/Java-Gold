package _00_Java_language;


import java.util.Scanner;

/**
 * 边界条件：
 * 1. 负数和0的处理方式
 * 2. 运算结果溢出如何处理
 */
public class Solution {
    public static int factorial(int n){
        if(n <= 1) return 1; //递归终止条件
        int res = n * factorial(n-1);
        if(res < 0)
            return 0;
        return res;
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
////        String s = sc.next();
////        try{
////            Integer i = Integer.valueOf(s);
////            System.out.println(factorial(i));
////        } catch (NumberFormatException e){
////            e.printStackTrace();
////        }

        String s = " 2 0";
        Integer i = Integer.valueOf(s);
        System.out.println(i);
    }
}
