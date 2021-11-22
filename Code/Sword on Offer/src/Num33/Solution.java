package Num33;

import java.util.Arrays;

public class Solution {
	public static boolean VerifySquenceOfBST(int [] sequence) {
		int len = sequence.length;
		if(len <= 0)
			return false;
		int root = sequence[len-1];
		int index = -1;
		boolean flag = true;
		for(int i=0; i < len-1; i++){
			if(sequence[i] > root){
				index = i;
				break;
			}
		}
		if(index == -1){ //说明没有存在右子树遍历的情况
			index = len-1;
		}
		int[] left_arr =  Arrays.copyOfRange(sequence,0,index);
		int[] right_arr = Arrays.copyOfRange(sequence,index,len-1);

		for(int i=index; i < len-1; i++){
			if(sequence[i] < root)
				return false;
		}
		if(index > 1){ //这里保证数组的长度必须大于1
			flag = flag & VerifySquenceOfBST(left_arr);
		}
		if(len-index > 1){
			flag = flag & VerifySquenceOfBST(right_arr);
		}
		return flag;
	}
	public static void main(String[] args){
		int[] a = {4,6,7,5};
		System.out.println(VerifySquenceOfBST(a));
	}
}
