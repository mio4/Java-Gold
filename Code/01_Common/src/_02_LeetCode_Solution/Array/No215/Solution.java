package _02_LeetCode_Solution.Array.No215;

import java.util.Arrays;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
