package _02_LeetCode_Solution.String.No43;

/**
 * 43. Multiply Strings
 * （1）当result在long的范围只能的时候，能够成功
 * （2）当num1和num2相乘的结果太长之后，result会溢出，WA
 */
class Solution {
    public static String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        long result = 0;
        int count1 = 1;
        int count2;
        for(int i=len2-1;i >= 0; i--){
            count2 = 1;
            for(int j=len1-1; j >= 0; j--){
                result += (num1.charAt(j)-'0') * (num2.charAt(i)-'0')*count1*count2;
                count2 *= 10;
            }
            count1 *= 10;
        }
        return String.valueOf(result);
    }

    public static void main(String[] args){
        String s1 = "123";
        String s2 = "456";
        System.out.println(multiply(s1,s2));
    }
}
