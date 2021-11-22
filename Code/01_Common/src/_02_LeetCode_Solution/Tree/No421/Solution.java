package _02_LeetCode_Solution.Tree.No421;

/**
 * 421. Maximum XOR of Two Numbers in an Array
 * TC O(n^2)
 * Brute Force
 */
class Solution {
    public int findMaximumXOR(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;
        int max = Integer.MIN_VALUE;
        for(int i=0; i < nums.length; i++){
            for(int j=0; j < nums.length; j++){
                if((nums[i]^nums[j]) > max)
                    max = nums[i]^nums[j];
            }
        }
        return max;
    }
}
