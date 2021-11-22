package _02_LeetCode_Solution.Array.No42;

/**
 * 优化第一种方法
 * 时间复杂度为O(n)
 * 空间复杂度为O(1)
 */
class Solution2 {
    public static int trap(int[] height) {
        int len = height.length;
        if(len <= 2) return 0;
        //1.找到最大值，作为中间的分割点
        int i;
        int area = 0;
        int max = -1,max_index = -1;
        for(i = 0; i < height.length; i++){
            if(height[i] > max){
                max = height[i];
                max_index = i;
            }
        }
        int root = height[0];
        //2.前半部分
        for(i = 0; i < max_index; i++){
            if(root < height[i]) root = height[i];
            else area += (root - height[i]);
        }
        //3.后半部分
        for(i = len-1,root = height[len-1]; i > max_index; i--){
            if(root < height[i]) root = height[i];
            else area += (root - height[i]);
        }

        return area;
    }

    public static void main(String[] args){
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(nums));
    }
}
