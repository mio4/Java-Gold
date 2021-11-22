package _03_SwordOnOffer.FindMinInRotateArray;

public class Solution {

    public static int findMin(int[] nums){
        int left = 0;
        int right = nums.length-1;
        int mid = (left+right)/2;
        //特殊情况处理
        if(left < mid && mid < right){
            return nums[left];
        }
        while(left <= right){
            //边界条件
            if(right-left == 1){
                return Math.min(nums[left],nums[right]);
            }

            if(mid > left) left = mid;
            else if(mid <= right) right = mid;
            mid = (left+right)/2;
        }

        return -1;
    }

    public static void main(String[] args) {
//        int arr[] = {8,9,10,11,12,13,14,15,6,7};
//        int arr[] = {3,4,5,1,2};
        int arr[] = {1,2,3,4,5,6,7};
        System.out.println(findMin(arr));
    }
}
