package CCF201503_1;
//简化代码：直接将矩阵坐标变换的结果输出，节约了内存
//Problem:显示内存超限
import java.util.Scanner;
public class Main2 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] matrix = new int[n][m];
		for(int i=0; i < n; i++)
			for(int j=0; j < m; j++)
				matrix[i][j] = sc.nextInt();

		for(int i=0; i < m; i++)
			for(int j=0; j < n; j++){
				if(j == n-1)
					System.out.print(matrix[j][m-i-1] + "\n");
				else
					System.out.print(matrix[j][m-i-1] + " ");
			}

	}
}
