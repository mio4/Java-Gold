package Num3;

public class Solution {
	public boolean Find(int target, int [][] array) {
		int n = array.length; //行数
		int m = array[0].length; //列数
		if(m == 0)
			return false;
		int i = 0;
		int j = m-1;
		while(true){
			if(array[i][j] == target) {
				return true;
			} else if(array[i][j] < target){
				i++; //排除本行
				if(i >= n)
					break;
			} else if (array[i][j] > target){
				j--; //排除本列
				if(j < 0)
					break;
			}
		}
		return false;
	}
}
