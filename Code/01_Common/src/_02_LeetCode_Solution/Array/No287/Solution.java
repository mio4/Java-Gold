package _02_LeetCode_Solution.Array.No287;

import java.util.Arrays;

/**
 * Rule Breaker
 */
class Solution {
    public static int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0; i < nums.length-1; i++){
            if(nums[i] == nums[i+1]){
                return nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1,3,4,2,2};
        System.out.println(findDuplicate(a));
    }
}