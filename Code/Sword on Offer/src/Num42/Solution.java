package Num42;

public class Solution {
	public static int FindGreatestSumOfSubArray(int[] array) {
		int sum = 0;
		int maxsum = 0x80000000;
		int len = array.length;
		for(int i=0; i < len; i++){
			if(sum <= 0){
				sum = array[i];
			} else{
				sum += array[i];
			}

			if(sum > maxsum)
				maxsum = sum;
		}

		return maxsum;
	}

	public static void main(String[] args){
		int[] a = {1,-2,3,10,-4,7,2,-5};
		System.out.println(FindGreatestSumOfSubArray(a));
	}
}
