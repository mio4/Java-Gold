package CCF201512_2;
//尝试使用第二种方法：
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

		//deal row
		for(int i=0; i < n; i++)
			for(int j=0; j < m-2; j++)
				if(abs(matrix[i][j]) == abs(matrix[i][j+1]) && abs(matrix[i][j]) == abs(matrix[i][j+2])){
					if(matrix[i][j] > 0)
						matrix[i][j] = -matrix[i][j];
					if(matrix[i][j+1] > 0)
						matrix[i][j+1] = -matrix[i][j+1];
					if(matrix[i][j+2] > 0)
						matrix[i][j+2] = -matrix[i][j+2];
				}

		//deal column
		for(int j=0; j < m; j++)
			for(int i=0; i < n-2; i++){
				if(abs(matrix[i][j]) == abs(matrix[i+1][j]) && abs(matrix[i][j]) == abs(matrix[i+2][j])){
					if(matrix[i][j] > 0)
						matrix[i][j] = -matrix[i][j];
					if(matrix[i+1][j] > 0)
						matrix[i+1][j] = -matrix[i+1][j];
					if(matrix[i+2][j] > 0)
						matrix[i+2][j] = -matrix[i+2][j];
				}
			}

		//remove
		for(int i=0;i < n; i++)
			for(int j=0; j < m; j++){
				if(matrix[i][j] < 0)
					matrix[i][j] = 0;
			}

		//print
		for(int i=0; i < n; i++)
			for(int j=0; j < m; j++){
				if(j == m-1)
					System.out.print(matrix[i][j] + "\n");
				else
					System.out.print(matrix[i][j] + " ");
			}
	}


	public static int abs(int x){
		if(x < 0)
			return -x;
		else
			return x;
	}
}
