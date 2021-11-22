package _02_LeetCode_Solution.BitComputing.No371;

public class Solution {

    public static int getSum(int a,int b){
        if(b == 0){
            return a;
        }
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return getSum(sum,carry);
    }

    public static void main(String[] args){
        System.out.println(getSum(5,17));
    }
}
