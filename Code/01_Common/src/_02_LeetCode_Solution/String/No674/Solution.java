package _02_LeetCode_Solution.String.No674;

/**
 * 这道题翻车了
 * 多谢test case
 * 越是简单的题越是要考虑清楚边界条件和条件转换
 */
class Solution {
    public static int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int len = 1;
        int max = 0;
        for(int i=1;i < nums.length; i++){
            if(nums[i] > nums[i-1])
                len++;
            else {
                max = len>max?len:max;
                len = 1;
            }
        }
        return (len > max?len:max);
    }

    public static void main(String[] args){
        int[] arr = {1,3,5,4,7};
        System.out.println(findLengthOfLCIS(arr));
        int[] arr2 = {2,2,2,2};
        System.out.println(findLengthOfLCIS(arr2));
        int[] arr3 = {3,0,6,2,4,7,0,0};
        System.out.println(findLengthOfLCIS(arr3));
    }
}
