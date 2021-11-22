package _02_LeetCode_Solution.Array.No42;

/**
 * 42. Trapping Rain Water
 *  时间复杂度为O(n^2)
 *  空间复杂度为O(1)
 *  遍历一遍，找到能够存储水的临界条件
 *
 */
class Solution {
    public static int trap(int[] height) {
        int len = height.length;
        if(len <= 2)
            return 0;
        int i;
        int contain = 0;
        for(i = 1; i < len-1; i++){
            int base_number = height[i];
            int l_max = getMax(height,0,i-1);
            int r_max = getMax(height,i+1,len-1);
            int max = Math.min(l_max,r_max);
            if(max > base_number)
                contain += (max - base_number);
        }
        return contain;
    }

    public static int getMax(int[] nums,int begin, int end){
        int i;
        int max = nums[begin];
        for(i = begin; i <= end; i++)
            if(nums[i] > max)
                max = nums[i];
        return max;
    }

    public static void main(String[] args){
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(nums));
    }
}
