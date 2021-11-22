package Num57_2;

import java.util.ArrayList;
public class Solution {
	public static ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(sum < 3)
			return result;
		int small = 1;
		int big = 2;
		while(small < (sum+1)/2){
			ArrayList<Integer> res = new ArrayList<Integer>();
			int ans = (small+big)*(big-small+1)/2;
			if(ans == sum){
				for(int i=small; i <= big; i++)
					res.add(i);
				result.add(res);
				big++;
			} else if(ans < sum){
				big++;
			} else if(ans > sum){
				small++;
			}
		}
		return result;
	}
	public static void main(String[] args){
		FindContinuousSequence(9);
	}
}