package _02_LeetCode_Solution.Interview._239;

class Solution {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        if(nums.length == 0){
            int[] t = new int[0];
            return t;
        }
        for(int i=0; i+k-1 < nums.length; i++){
            int max = nums[i];
            for(int j=i; j <= i+k-1; j++){
                max = Math.max(max,nums[j]);
            }
            res[i] = max;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        maxSlidingWindow(nums,3);
    }
}
