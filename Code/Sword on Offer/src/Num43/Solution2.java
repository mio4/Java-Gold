package Num43;

public class Solution2 {
	public static int NumberOf1Between1AndN_Solution(int n) {
		int cnt = 0;

		return cnt;
	}

	public static int NumberOfXBetween1AndN_Solution(int n, int x){ //x的范围是1~9
		int cnt = 0;
		int time_cnt_n = n;
		int time_cnt = 0; //应该循环的次数
		int time = 0; //当前循环到几次
		while(time_cnt_n > 10){
			time_cnt++;
			time_cnt_n /= 10;
		}

		while(time < time_cnt){
			cnt += n/(Math.pow(10,time+1)) * Math.pow(10,time); //首先加上基础值

			time++;
		}

		return cnt;
	}

	public static void main(String[] args){
		System.out.println(NumberOf1Between1AndN_Solution(2593));
		System.out.println(NumberOfXBetween1AndN_Solution(2593,5));
	}
}
