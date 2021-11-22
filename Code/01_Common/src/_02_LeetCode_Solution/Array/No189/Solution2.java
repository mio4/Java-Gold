package _02_LeetCode_Solution.Array.No189;

/**
 * 1. 首先将整体旋转
 * 2. 然后对于分开的两部分再进行旋转
 */
class Solution2 {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        reverse(nums,0,len-1);
        reverse(nums,0,k-1);
        reverse(nums,k,len-1);
    }
    public void reverse(int[] nums,int begin, int end){
        while(begin < end){
            int temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            begin++;
            end--;
        }
    }
}
