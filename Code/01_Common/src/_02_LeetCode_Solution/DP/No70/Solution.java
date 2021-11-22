package _02_LeetCode_Solution.DP.No70;

public class Solution {
    public static int climbStairs(int n) {
        if(n == 1)
            return 1;
        else if(n == 2)
            return 2;
        int pre_one = 2;
        int pre_two = 1;
        int tmp;
        for(int i=0; i < n-2; i++){
            tmp = pre_one;
            pre_one = pre_one + pre_two;
            pre_two = tmp;
        }
        return pre_one;
    }

    public static void main(String[] args){
        System.out.println(climbStairs(1));
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
    }
}
