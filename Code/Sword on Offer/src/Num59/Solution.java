package Num59;

import java.util.ArrayList;

public class Solution {
	public static ArrayList<Integer> maxInWindows(int [] num, int size)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		int len = num.length; //对于数组取长为length属性，对于ArrayList取长为size()方法
		if(num == null ||size <= 0 ||  size >len) //对于边界情况进行考虑
			return result;

		//对于一般情况的一般算法
		int j = 0;
		while(j <= len-size){
			int max = num[j];
			for(int i=j; i < size+j; i++)
				if(num[i] > max)
					max = num[i];
			result.add(max);
			j++;
		}

		return result;
	}

	public static void main(String[] args){
		int[] a = {2,3,4,2,6,2,5,1};
		maxInWindows(a,3);
	}
}

