package Jump;

import java.util.Scanner;

//第一次错误在于对于last_score的赋值出错
//Scanner类的in.nextInt()不断读入整数是一个不错的选择
public class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int score = 0;
		int last_score = 0;
		int x = in.nextInt();
		while(x != 0){
			if(x == 1) {
				score += 1;
				last_score = 1;
			} else if (x == 2){
				if(last_score == 1 || score == 0) {
					score += 2;
					last_score = 2;
				}
				else {
					score = score + last_score + 2;
					last_score = last_score + 2;
				}
			}
			x = in.nextInt();
		}
		System.out.println(score);
	}
}
