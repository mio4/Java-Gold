package Num40;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		int len = input.length;
		Arrays.sort(input);
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(k >= len){ //对于边界条件的处理
			return result;
		}
		for(int i=0; i < k; i++)
			result.add(input[i]);
		return result;
	}
}
