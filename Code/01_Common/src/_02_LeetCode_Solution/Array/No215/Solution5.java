package _02_LeetCode_Solution.Array.No215;

/**
 * 自我实现一遍二分查找
 * TODO
 * 这道题非常经典，需要好好思考一下
 */
class Solution5 {
    public int findKthLargest(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        //1.找到nums中的最大值和最小值
        for(int num : nums){
            min = Math.min(min,num);
            max = Math.max(max,num);
        }
        //2.使用二分法，不断接近真值
        while(min <= max){
            int mid = (min+max)/2;
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
                max = mid - 1;
            else
                min = mid + 1;
        }
        return -1;
    }
}
