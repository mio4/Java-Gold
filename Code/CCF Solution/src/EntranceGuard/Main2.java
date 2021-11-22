package EntranceGuard;
//注意审题：读者的编号为不超过n的正整数
//输入的时候同时输出能够通过OJ
import java.util.Scanner;
public class Main2 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] counts = new int[1001];
		int i = 0;
		while(i < n){
			int x = sc.nextInt();
			counts[x]++;
			System.out.print(counts[x] + " ");
			i++;
		}
	}
}
