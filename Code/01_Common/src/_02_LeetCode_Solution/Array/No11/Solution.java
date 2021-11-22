package _02_LeetCode_Solution.Array.No11;

/**
 * AC at once
 * TC[Time Complexity] : O(n^2)
 */
class Solution {
    public int maxArea(int[] height) {
        int max_area = 0;
        for(int i=0; i < height.length; i++){
            for(int j=i+1; j < height.length; j++){
                max_area = Math.max(max_area,(j-i)*(height[i]<height[j]?height[i]:height[j]));
            }
        }
        return max_area;
    }
}
