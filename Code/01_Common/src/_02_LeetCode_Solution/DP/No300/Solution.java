package _02_LeetCode_Solution.DP.No300;

//TODO
class Solution {
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int min = nums[0];
        for(int i=1; i < nums.length; i++){
            if(nums[i] > min)
                dp[i] = dp[i-1]+1;
            else
                dp[i] = dp[i-1];
            if(nums[i] < min)
                min = nums[i];
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args){
        int[] arr = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(arr));
    }
}
