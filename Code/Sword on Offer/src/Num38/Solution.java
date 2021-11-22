package Num38;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	public ArrayList<String> Permutation(String str) {
		ArrayList<String> result = new ArrayList<String>();
		if(str == null) //边界条件
			return result;

		char[] cs = str.toCharArray();
		PermutationHelper(cs,0,result);
		Collections.sort(result);
		return result;
	}
	public void PermutationHelper(char[] cs, int i, ArrayList<String> result){ //字符集合，固定元素位置，结果集
		if(i == cs.length-1){
			if(!result.contains(new String(cs))){
				result.add(new String(cs));
				return; //返回到上一层
			}
		} else{
			for(int j=i; j < cs.length; j++){
				Swap(cs,i,j);
				PermutationHelper(cs,i+1,result);
				Swap(cs,i,j); //复原数组到上一步
			}
		}
	}

	public void Swap(char[] cs, int i, int j){
		char tmp = cs[i];
		cs[i] = cs[j];
		cs[j] = tmp;
	}
}
