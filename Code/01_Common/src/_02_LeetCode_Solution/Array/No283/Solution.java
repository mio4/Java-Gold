package _02_LeetCode_Solution.Array.No283;

import java.util.Arrays;

/**
 * 1. 需要额外数组开销
 */
public class Solution {
    public static void moveZeroes(int[] nums) {
        int[] nums_t = new int[nums.length];
        int j = 0;
        for(int i=0; i < nums.length; i++){
            if(nums[i] != 0){
                nums_t[j++] = nums[i];
            }
        }
        for(int i=0; i < nums.length; i++){
            nums[i] = nums_t[i];
        }
    }

    public static void main(String[] args){
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
