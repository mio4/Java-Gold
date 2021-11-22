package CCF201409_2;
//这道题和消除游戏一样，看似很难解决，实质上算法很简单
//都是涉及到对矩阵判定的问题，都使用辅助矩阵尽心判断
//对于重复的部分进行标记，然后每读入一个矩阵，看所有的正方形是否产生重合
import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean[][] marks = new boolean[101][101]; //marks表示格子是否被占用，所以起始包含x1,但是终结时不包含x2
		int sum = 0;
		for(int i=0;i < n; i++){
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			sum += (x2-x1) * (y2-y1);
			//去重
			for(int j=x1; j < x2; j++)
				for(int k=y1; k < y2; k++){
					if(marks[j][k])
						sum--;
					marks[j][k] = true;
				}
		}
		System.out.println(sum);
	}
}
