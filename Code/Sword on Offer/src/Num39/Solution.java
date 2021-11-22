package Num39;

import java.util.ArrayList;

public class Solution {
	public static void main(String[] args){
		int[] a = {1,2,3,2,2,2,5,4,2};
		System.out.println(MoreThanHalfNum_Solution(a));
	}

	public static int MoreThanHalfNum_Solution(int [] array) {
		int len = array.length;
		ArrayList<Num> nums = new ArrayList<Num>();
		for(int i=0; i < len;i++){
			int j = 0;
			for(; j < nums.size(); j++){
				if(array[i] == nums.get(j).num) {
					nums.get(j).cnt++;
					break;
				}
			}
			if(j == nums.size())
				nums.add(new Num(array[i]));
		}
		for(int i=0; i < nums.size(); i++){
			if(nums.get(i).cnt >= len/2)
				return nums.get(i).num;
		}
		return 0;
	}
}
class Num {
	public int num;
	public int cnt = 0;
	public Num(int num){
		this.num = num;
	}
}
