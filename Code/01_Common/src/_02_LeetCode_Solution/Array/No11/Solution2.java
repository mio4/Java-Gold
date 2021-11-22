package _02_LeetCode_Solution.Array.No11;

/**
 * 设置双指针，从左往右和从右往左同时移动
 * 对于height[i] > height[j]，则base_height = height[j]，那么固定这个j，其他所有的i对max_area的计算都没有意义，所以需要考虑其他的j情况(j--)
 * 同理...
 * TC O(n)
 *
 */
class Solution2 {
    public int maxArea(int[] height) {
        int mx = 0,i = 0,j = height.length-1;
        while(i < j){
            mx = Math.max(mx,(j-i)*(height[i]<height[j]?height[i]:height[j]));
            if(height[i] < height[j]) i++;
            else j--;
        }
        return mx;
    }
}
