package _02_LeetCode_Solution.Array.No84;

import java.util.Arrays;
import java.util.Stack;

/**
 * http://www.cnblogs.com/lichen782/p/leetcode_Largest_Rectangle_in_Histogram.html
 * TODO
 * 使用栈：时间复杂度为O(n^2)
 */
class Solution2 {
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int maxArea = 0;
        int[] h = new int[heights.length + 1];
        h = Arrays.copyOf(heights, heights.length + 1);
        while(i < h.length){
            if(stack.isEmpty() || h[stack.peek()] <= h[i]){
                stack.push(i++);
            }else {
                int t = stack.pop();
                maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        return maxArea;
    }

    public static void main(String[] args){
        int[] nums = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(nums));
    }
}
