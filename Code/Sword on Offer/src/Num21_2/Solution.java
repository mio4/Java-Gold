package Num21_2;

public class Solution {
	public static void reOrderArray(int [] array) {
		int[] new_a = new int[array.length];
		int index = 0;
		for(int i=0;i < array.length; i++){
			if(array[i]%2!=0) {
				new_a[index] = array[i];
				index++;
			}
		}
		for(int i=0;i < array.length; i++){
			if(array[i]%2 == 0) {
				new_a[index] = array[i];
				index++;
			}
		}

		for(int i=0; i < array.length; i++){
			array[i] = new_a[i];
		}
	}

	public static void main(String[] args){
		int[] num = {1,2,3,4,5,6,7,8,9,10};
		reOrderArray(num);
		for(int i=0; i < 10; i++){
			System.out.println(num[i]);
		}
	}
}
