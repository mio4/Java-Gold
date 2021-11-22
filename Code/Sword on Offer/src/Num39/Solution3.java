package Num39;

public class Solution3 {
	public static int MoreThanHalfNum_Solution(int [] array) {
		if(array.length <= 0) //检查数组有效性
			return 0;
		int result = array[0];
		int times = 1;
		int len = array.length;
		for(int i=1; i < len; i++){
			if(array[i] == result)
				times++;
			else
				times--;
			if(times == 0) {
				result = array[i];
				times = 1;
			}
		}
		if(!checkIfMoreThanHalf(array,result))
			return 0;
		return result;
	}
	public static boolean checkIfMoreThanHalf(int[] array, int result){
		boolean flag = false;
		int len = array.length;
		int times = 0;
		for(int i=0; i < len; i++){
			if(array[i] == result)
				times++;
		}
		if(times * 2 > len)
			flag = true;
		return flag;
	}
	public static void main(String[] args){
		int[] a = {1,2,3,2,2,2,5,4,2};
		int[] b = {1,2,3,2,4,2,5,2,3};
		//System.out.println(MoreThanHalfNum_Solution(a));
		System.out.println(MoreThanHalfNum_Solution(b));
	}
}
