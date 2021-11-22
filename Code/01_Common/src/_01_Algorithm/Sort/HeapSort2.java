package _01_Algorithm.Sort;

import java.util.Arrays;

/**
 * 小顶堆-->降序排列
 */
public class HeapSort2 {

    public static void heapSort(int[] nums){
        int len = nums.length;
        for(int i=len/2-1; i >= 0; i--){
            adjustHeap(nums,i,len);
        }
        for(int i=len-1; i >= 0; i--){
            swap(nums,0,i);
            adjustHeap(nums,0,i);
        }
    }

    public static void adjustHeap(int[] nums,int i, int len){
        int temp = nums[i];
        for(int k=2*i+1; k < len; k=2*k+1){
            if(k+1 < len && nums[k] > nums[k+1])
                k+=1;
            if(nums[i] > nums[k]){
                nums[i] = nums[k];
                i = k;
            }
        }
        nums[i] = temp;
    }


    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args){
        int[] arr = {4,6,8,5,9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
