package XiaoZhao.WhitePadProgramming;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] nums,int left,int right){
        if(left >= right)
            return;
        int pivot = nums[left];
        int i = left;
        int j = right;
        while(i < j){
            while(i < j && nums[j] >= pivot) j--;
            while(i < j && nums[i] <= pivot) i++;
            if(i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        nums[left] = nums[i];
        nums[i] = pivot;
        quickSort(nums,left,i-1);
        quickSort(nums,i+1,right);
    }

    public static void main(String[] args){
//        int[] a = {9,8,5,7,3,2,4,1};
        int[] a = {5,4,3,2};
        quickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
