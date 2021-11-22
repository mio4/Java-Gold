package _02_LeetCode_Solution.Array.No136;

import java.util.Arrays;

class Solution {
    public static int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int len = nums.length;
        if(len == 1)
            return nums[0];
        Arrays.sort(nums);
        //1. 比较首位元素
        if(nums[0] != nums[1])
            return nums[0];
        if(nums[len-1] != nums[len-2])
            return nums[len-1];
        //2. 比较一般元素
        for(int i=1; i < len-1; i++){
            if(nums[i] != nums[i-1] && nums[i] != nums[i+1])
                return nums[i];
        }
        return 0;
    }

    public static void main(String[] args){
        int[] a1 = {2,2,1};
        System.out.println(singleNumber(a1));
        int[] a2 = {4,1,2,1,2};
        System.out.println(singleNumber(a2));
    }
}
