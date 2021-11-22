package _01_Algorithm.Sort;

import java.util.Arrays;

import static _01_Algorithm.Sort.HeapSort2.adjustHeap;

public class topK {

    public static int[] findTopK(int[] arr, int k){
        int[] heap = Arrays.copyOf(arr,k);
        for(int i=k/2-1; i >= 0; i--){
            adjustHeap(heap,i,k);
        }
        for(int i=k; i < arr.length; i++){
            if(arr[i] > heap[0]) {
                heap[0] = arr[i];
                adjustHeap(heap,0,k);
            }

        }
        return heap;
    }

    public static void main(String[] args){
        //int[] arr = {4,6,8,5,9};
        int[] arr = {4,6,8,5,9,100,3,5,200,48,70,300};
        int[] nums = findTopK(arr,3);
        System.out.println(Arrays.toString(nums));
    }
}
