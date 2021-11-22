package Num45;

public class Solution {
	public static String PrintMinNumber(int [] numbers) {
		String result = "";
		if(numbers == null)
			return null;
		if(numbers.length == 0)
			return result;
		int len = numbers.length;


		String[] strs = new String[numbers.length];
		for(int i=0; i < len; i++){
			strs[i] = String.valueOf(numbers[i]);
		}
		BubbleSort(strs,len);

		for(int i=0; i < len; i++){
			result += strs[i];
		}
		return result;
	}

	public static void BubbleSort(String[] strs, int len){
		for(int i=0; i < len; i++){
			for(int j=0; j < len-1-i;j++){
				if(BiggerThanOrEqual(strs[j],strs[j+1])){
					String temp = strs[j];
					strs[j] = strs[j+1];
					strs[j+1] = temp;
				}
			}
		}
	}

	public static boolean BiggerThanOrEqual(String a, String b){  //a是否大于等于b
		String ab = a + b;
		String ba = b + a;
		int len = ab.length();
		for(int i=0; i < len; i++){
				if(ab.charAt(i) > ba.charAt(i))
					return true;
				else if(ab.charAt(i) < ba.charAt(i))
					return false;
		}
		return true;
	}

	public static void main(String[] args){
		int[] a = {3,32,321};
		System.out.println(PrintMinNumber(a));
	}
}
