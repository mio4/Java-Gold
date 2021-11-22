package _01_Algorithm.Sort;

import java.util.Arrays;

/**
 * 归并排序：
 * （1）MergeSort3(int[] arr, int low, int high) low和high在数组中合并的范围
 * （2）Merge(int[] arr,int low, int mid, int high) low/mid/high将一个数组拆分为两个部分
 *      每次将数组的两个部分从新数组拷贝到原有的数组
 * （3）时间复杂度为O(N*logN)，空间复杂度为O(n)
 */
public class MergeSort {

    public static void MergeSort(int[] arr, int low, int high){
        if(low < high){
            int mid = (low+high)/2;
            MergeSort(arr,low,mid);
            MergeSort(arr,mid+1,high);
            Merge(arr,low,mid,high);
        }
    }

    public static void Merge(int[] arr,int low, int mid, int high){
        int[] plus = Arrays.copyOf(arr,arr.length);
        int i,j,k;
        for(i=low,j=mid+1,k=i; i <= mid && j<= high; k++){
            if(plus[i] <= plus[j])
                arr[k] = plus[i++];
            else
                arr[k] = plus[j++];
        }
        while(i <= mid) arr[k++] = plus[i++];
        while(j <= high) arr[k++] = plus[j++];
    }

    public static void main(String[] args){
        int[] arr = {49,38,65,97,13,76,27};
        MergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
