package Num8;

import java.util.ArrayList;
public class Solution {
	public static int minNumberInRotateArray(int [] array) {
		int index1 = 0;
		int index2 = array.length-1;
		int mid_index = index1;

		//这里有两种情况：
		//1.数组发生了旋转，必定会进入循环体内
		//2.数组没有发生旋转，直接返回array[mid_index]，此时数组的最小值就是第一个值
		while(array[index1] >= array[index2]){
			//找到最小值
			if(index1+1 == index2) {
				mid_index = index2;
				break;
			}
			mid_index = (index1 + index2) / 2;

			//考虑一种边界情况，需要改变查找方式为顺序查找
			if(array[index1]==array[mid_index] && array[mid_index]==array[index2])
				return findmin(array,index1,index2);

			//一般情况处理
			if(array[mid_index] >= array[index1])
				index1 = mid_index;
			else if(array[mid_index] <= array[index2])
				index2 = mid_index;
		}

		return array[mid_index];
	}

	public static int findmin(int[] array, int index1, int index2){
		int min = array[index1];
		for(int i=0; i <= index2; i++)
			if(array[i] < min)
				min = array[i];
		return min;
	}

	public static void main(String[] args){
		int[] a = {3,4,5,1,2};
		System.out.println(minNumberInRotateArray(a));
	}
}
