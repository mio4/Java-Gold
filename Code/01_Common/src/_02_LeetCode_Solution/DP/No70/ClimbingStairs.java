package _02_LeetCode_Solution.DP.No70;

/**
 * 直接使用递归会TLE
 */
public class ClimbingStairs {
    public static int climbStairs(int n) {
        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;
        else if(n == 2)
            return 2;
        return climbStairs(n-1) + climbStairs(n-2);
    }

    public static void main(String[] args){
        System.out.println(climbStairs(1));
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
    }

}
