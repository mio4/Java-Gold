package XiaoZhao.WhitePadProgramming;

import java.util.Arrays;

/**
 * 改进后的冒泡排序
 */
public class BubbleSort {
    public static void bubbleSort(int[] nums){
        for(int i=0; i < nums.length; i++){
            boolean isSort = true;
            for(int j=0; j < nums.length-i-1; j++){
                if(nums[j] > nums[j+1]){
                    isSort = false;
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
            if(isSort) break;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args){
        int[] a = {9,8,5,7,3,2,4,1};
        bubbleSort(a);
    }
}
