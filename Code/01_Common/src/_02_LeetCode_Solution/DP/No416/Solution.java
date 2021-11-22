package _02_LeetCode_Solution.DP.No416;

class Solution {
    public static boolean canPartition(int[] nums) {
        if(nums == null || nums.length < 2){
            return false;
        }
        int sum = 0;
        for(int i=0; i < nums.length; i++){
            sum += nums[i];
        }
        if(sum % 2 != 0){
            return false;
        }

        int target = sum/2;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for(int num : nums){
            for(int i = target; i >= num; i--){
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[target];
    }

    public static void main(String[] args){
        int[] arr = {1,5,11,5};
        System.out.println(canPartition(arr));

        int[] arr2 = {1,2,3,5};
        System.out.println(canPartition(arr2));
    }
}