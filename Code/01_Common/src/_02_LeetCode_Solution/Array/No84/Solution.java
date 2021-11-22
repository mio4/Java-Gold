package _02_LeetCode_Solution.Array.No84;

/**
 * 朴素解法：不限制时间复杂度和空间复杂度
 * 时间复杂度为O(n^2)
 */
class Solution {
    public static int largestRectangleArea(int[] heights) {
        int max_area = 0; //长方形的最大面积
        int len = heights.length;
        for(int i=0; i < len; i++){
            if(heights[i] > max_area)
                max_area = heights[i];
            int low_height = heights[i];
            for(int j = i; j < len; j++){
                if(heights[j] < low_height)
                    low_height = heights[j];
                if(low_height*(j-i+1) > max_area)
                    max_area = low_height*(j-i+1);
            }
        }
        return max_area;
    }

    public static void main(String[] args){
        int[] nums = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(nums));
    }
}
