package Num10;

public class Solution {
	public static void main(String[] args){
		int n = 9;
		int count = 0;
		int flag = 1;
		while(flag >= 0){
			if((n & flag) == 1){
				count++;
			}
			flag = flag << 1;
		}
	}
}
