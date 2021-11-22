package Num21_2;

public class Solution2 {
	public static void reOrderArray(int [] array) {
		if(array == null || array.length == 0)
			return;
		int begin = 0;
		int end = array.length-1;
		while(begin < end){
			while(array[begin] %2 != 0 && begin < end) //找到一个偶数
				begin++;
			while(array[end] %2 == 0 && begin < end) //找到一个奇数
				end--;
			int tmp = array[begin];
			array[begin] = array[end];
			array[end] = tmp;
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
