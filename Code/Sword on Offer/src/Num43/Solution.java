package Num43;

public class Solution {
	public static int NumberOf1Between1AndN_Solution(int n) {
		int cnt = 0;
		for(int i=1; i <= n; i++){
			cnt += getOneNum(i);
		}
		return cnt;
	}

	public static int getOneNum(int n){
		int cnt = 0;
		while(n != 0){
			if(n % 10 == 1)
				cnt++;
			n /= 10;
		}
		return cnt;
	}

	public static void main(String[] args){
		//System.out.println(getOneNum(11));
		System.out.println(NumberOf1Between1AndN_Solution(21345));
	}
}
