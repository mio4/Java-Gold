package _02_LeetCode_Solution.Interview._494;

class Solution {
    private static int res = 0;
    public static int findTargetSumWays(int[] nums, int S) {
        helper(nums,0,S);
        return res;
    }

    private static void helper(int[] nums,int index,int sum){
        if(index == nums.length){
            if(sum == 0)
                res++;
            return;
        }
        helper(nums,index+1,sum-nums[index]);
        helper(nums,index+1,sum+nums[index]);
    }

    public static void main(String[] args) {
//        int[] nums = {1,1,1,1,1};
//        System.out.println(findTargetSumWays(nums,3));

        int[] nums2 = {1};
        System.out.println(findTargetSumWays(nums2,1));
    }
}
