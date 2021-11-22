package Num39;
import java.util.Arrays;
public class Solution2 {
	public static int MoreThanHalfNum_Solution(int [] array) {
		Arrays.sort(array);
		int len = array.length;
		int before = array[0];
		int cnt = 1;
		if(len == 1)
			return array[0];
		for(int i=1; i < len; i++){
			if(cnt > len/2)
				return before;
			if(array[i] != before){
				cnt = 1;
				before = array[i];
			} else {
				cnt++;
			}
		}
		return 0;
	}
	public static void main(String[] args){
		int[] a = {1,2,3,2,4,2,5,2,3};
		System.out.println(MoreThanHalfNum_Solution(a));
	}
}
