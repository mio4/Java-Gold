package _04_Nowcoder_19Hire.kuaishou._05;

/**
 * https://www.nowcoder.com/practice/8705437354604a7cb9ba7bf959e42de6?tpId=98&tqId=32855&tPage=2&rp=2&ru=/ta/2019test&qru=/ta/2019test/question-ranking
 * Classic Problem
 * 求数组子串和的最大值
 *  [1]一维dp数组
 *      dp[i]表示遍历到i时，当前遍历情况存放的最大值，后续可能存在清空
 *      比如 -1,-1,2,-10,-10
 *  [2]最大的情况：遍历dp数组，找到数组中的最大值
 */
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] s = sc.next().split(",");
        int[] nums = new int[s.length];
        int[] dp = new int[s.length];
        int cur = 0;
        for(int i=0; i < s.length; i++){
            nums[i] = Integer.parseInt(s[i]);
            cur += nums[i];
            if(cur > 0){
                dp[i] = cur;
            }
            else{
                cur = 0;
            }
        }

        int max = dp[0];
        for(int i=0 ; i < nums.length; i++){
            max = max > dp[i] ? max : dp[i];
        }
        System.out.println(max);
    }
}
