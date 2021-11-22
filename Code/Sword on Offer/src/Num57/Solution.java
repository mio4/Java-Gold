package Num57;

import java.util.ArrayList;
public class Solution {
	public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(array == null || array.length == 0) //边界情况
			return result;

		int len = array.length;
		int i = 0;
		int j = len-1;
		while(i != j){
			if(array[i] + array[j] == sum){
				result.add(array[i]);
				result.add(array[j]);
				break;
			} else if(array[i] + array[j] < sum){
				i++;
			} else if(array[i] + array[j] > sum){
				j--;
			}
		}
		return result;
	}
}
