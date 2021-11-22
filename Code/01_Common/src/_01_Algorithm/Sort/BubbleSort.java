package _01_Algorithm.Sort;

import java.util.Arrays;

/**
 * 手写一个冒泡排序算法
 * 1. i表示当前处于第几次循环【控制i则控制了循环的次数】
 * 2. j表示当前对比的字符【控制j则表示控制当前对比的范围】
 */
public class BubbleSort {

    public static void bubbleSort(int nums[]){
        int i, j;
        int len = nums.length;
        for(i = 0; i < len-1;i++){
            for(j=0; j < len-i-1; j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args){
        int[] nums = {3,2,4,5,7,6,1,9,8};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
