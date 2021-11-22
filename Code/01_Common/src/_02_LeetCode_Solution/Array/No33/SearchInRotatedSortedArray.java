package _02_LeetCode_Solution.Array.No33;

public class SearchInRotatedSortedArray {
    /**
     * 1.
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0,right = len-1;
        int mid;
        while(left <= right){
            mid = (left + right) / 2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < nums[right]){
                if(nums[mid] < target && nums[right] >= target)
                    left = mid + 1;
                else
                    right = mid - 1;
            }
            else{
                if(nums[mid] > target && nums[left] <= target)
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(search(arr,0));
        System.out.println(search(arr,3));
    }
}
