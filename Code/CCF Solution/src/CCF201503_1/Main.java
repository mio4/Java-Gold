package CCF201503_1;
//实质就是一个矩阵旋转题
import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] old_m = new int[n][m];
		int[][] new_m = new int[m][n];
		for(int i=0; i < n; i++)
			for(int j=0; j < m; j++)
				old_m[i][j] = sc.nextInt();
		for(int i=0; i < m; i++)
			for(int j=0; j < n; j++)
				new_m[i][j] = old_m[j][m-i-1];
		for(int i=0; i < m; i++)
			for(int j=0; j < n; j++){
				if(j == n-1)
					System.out.print(new_m[i][j] + "\n");
				else
					System.out.print(new_m[i][j] + " ");
			}
	}
}
