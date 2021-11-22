package other;

import java.util.Arrays;

public class HandwriteQuickSort {

    public static void quickSort(int[] nums,int left, int right){
        int base = nums[left];
        int i = left,j = right;
        while(i < j){
            while(nums[j] >= base && i < j) j--;
            while(nums[i] <= base && i < j) i++;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        nums[left] = nums[i];
        nums[i] = base;
        if(left < i-1)
            quickSort(nums,left,i-1);
        if(i+1 < right)
            quickSort(nums,i+1,right);
    }

    public static void main(String[] args){
        int[] nums = {9,8,7,6,5,4,3,2,1};
        quickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}
