package other.KaoYan;

import java.util.Arrays;

public class HandWriteBubbleSort {

    public static void BubbleSort(int[] nums){
        int len = nums.length;
        for(int i = 0; i < len-1; i++){
            for(int j=0; j < len-i-1; j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j]= nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args){
        int[] nums = {9,8,7,6,5,4,3,2,1};
        BubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
