package _02_LeetCode_Solution.DP.No53;

/**
 *  53. Maximum Subarray
 *  初始化的时候使用Integer.MIN_VALUE模拟最小值
 *  （1）Brute Force O(n^2)
 */
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        int max_sum = Integer.MIN_VALUE;
        int cur_sum;
        for(int i=0; i < nums.length; i++) {
            cur_sum = 0;
            for (int j = i; j < nums.length; j++) {
                cur_sum += nums[j];
                max_sum = Math.max(max_sum,cur_sum);
            }
        }
        return max_sum;
    }

}
