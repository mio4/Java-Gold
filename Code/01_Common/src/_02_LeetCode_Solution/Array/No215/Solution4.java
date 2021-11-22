package _02_LeetCode_Solution.Array.No215;

/**
 * 反复筛选数组中的元素而不对原有的数组进行修改
 * （1）不同于传统的二分排序【针对数组的下标】，而是针对数组中的值的排序
 * （2）只适用于int整形的方式
 */
class Solution4 {
    public int findKthLargest(int[] nums, int k) {
        int left = Integer.MAX_VALUE;
        int right  = Integer.MIN_VALUE;

        for(int num : nums){ //首先找到数组中的最大值和最小值-->作为边界条件
            left = Math.min(num,left);
            right = Math.max(num,right);
        }

        while(left <= right){
            int mid = left + (right - left)/2;
            int count1 = 0;
            int count2 = 0;
            for(int num : nums){
                if(num >= mid)
                    count1++;
                if(num > mid)
                    count2++;
            }
            if(count1 >= k && count2 < k)
                return mid;

            if(count1 < k)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return -1;
    }
}
