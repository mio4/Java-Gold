package _01_Algorithm.Sort;

import java.util.Arrays;

/**
 * 归并排序
 * [1]先将数组拆分为单个数字
 * [2]逐渐合并单个数组
 * [3]得到最终结果
 *
 * 左右两边分治
 * mergeSort()
 * mergeSort()
 * 合并排序之后的结果
 * merge()
 *
 * 时间复杂度O(N*logN)
 * 空间复杂度O(N)
 */
public class MergeSort3 {


    public static void mergeSort(int[] nums,int left,int right){
        if(left == right){
            return;
        }
        int mid = left + ((right - left) >> 1);
        mergeSort(nums,left,mid);
        mergeSort(nums,mid+1,right);
        merge(nums,left,mid,right);
    }

    public static void merge(int[] nums,int left,int mid,int right){
        int p1 = left;
        int p2 = mid+1;
        int[] t = new int[right-left+1];
        int i = 0;
        while(p1 <= mid && p2 <= right){
            t[i++] = nums[p1] < nums[p2] ? nums[p1++] : nums[p2++];
        }
        //清理剩余数组
        while(p1 <= mid){
            t[i++] = nums[p1++];
        }
        while(p2 <= right){
            t[i++] = nums[p2++];
        }

        //复制到原数组
        for(int j=0; j < t.length; j++){
            nums[left+j] = t[j];
        }
    }

    public static void main(String[] args) {
        int[] a = {8,3,6,4,2,1,5,7};
        mergeSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
