package _01_Algorithm.Sort;

import java.util.Arrays;

/**
 * 手写快速排序
 * 1. 快排和冒泡排序都是选择排序的一种
 * 2. 快排的平均时间复杂度为O(N*logN)
 * 3. 标准快排的原则：
 * （1）选择nums[left]为base number
 * （2）base number左边的数都小于它，右边的数都大于它
 * （3）设置递归，将排序每次分为base number左边的部分和右边的部分
 * （4）在函数开始时，设置递归结束条件（return），避免不必要的比较
 * （5）每次从基准值的另外一边开始比较
 */
public class QuickSort {

    public static void quickSort(int nums[],int left, int right){
        int i = left,j = right;
        int base = nums[left];
        while(i < j){
            while(nums[j] >= base && i < j)
                j--;
            while(nums[i] <= base && i < j)
                i++;
            if(i < j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        nums[left] = nums[i];
        nums[i] = base;
        if(left < i-1) {
            quickSort(nums, left, i - 1);
        }
        if(i+1 < right) {
            quickSort(nums, i + 1, right);
        }
    }

    public static void main(String[] args){
        int[] nums = {6,1,2,7,9,3,4,5,10,8};
        quickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}
