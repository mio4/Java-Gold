package _01_Algorithm;

/**
 * 最长上升子序列
 * dp[i]表示前i个数/字符最长上升子序列的长度
 * dp[i] = max(1,dp[j]+1) (j = 0,1...i-1 && nums[j] < nums[i])
 *
 * 动态规划的边界问题：
 * (1)i和j的定义和数组从0开始的调整
 * (2)dp[i]规定了结束的字符，子序列结束的字符不确定，所以要求max(dp)
 */
public class LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int dp[] = new int[nums.length+1];
        int max = 1;
        for(int i=0; i < nums.length; i++){
            dp[i+1] = 1; //初始化
            for(int j=0; j < i; j++){
                if(nums[j] < nums[i] && dp[j+1]+1 > dp[i+1]) {
                    dp[i+1] = dp[j+1]+1;
                }
            }
            max = Math.max(max,dp[i+1]);
        }
        return max;
    }


    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }

}
