package _02_LeetCode_Solution.DP.No53;

/**
 * Congratulations! 使用动态规划数组解决了问题
 * 可以看出动态规划的总体思想就是使用空间换时间【比如斐波拉契数组的动态规划解法】：
 * （1）如果前面的和小于零，那么说明应该从当前数字开始计算新的和，否则可以加上前面的影响
 * （2）递推方程：dp[i] = max(dp[i-1]+nums[i],nums[i])
 */
class Solution2 {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        int max_sum = nums[0];
        int[] dp = new int[nums.length];
        for(int i=0; i < nums.length ;i++){
            if(i == 0){
                dp[i] = nums[i];
            } else{
                dp[i] = dp[i-1]<0 ? nums[i] : dp[i-1]+nums[i];
                max_sum = Math.max(max_sum,dp[i]);
            }
        }
        return max_sum;
    }
}
