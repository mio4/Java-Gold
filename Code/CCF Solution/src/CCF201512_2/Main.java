package CCF201512_2;
//消除类游戏
//最开始想到的是使用递归：对于每一个点进行周围的判断，非常麻烦
//看了题解之后：使用辅助存储矩阵，对于每一个超过3连号的情况都可以拆分为3连号的情况
//对于所有需要被消除的点，只需要做好标记，然后统一清空
//缺点：提高了空间复杂度
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] grap = new int[n][m];
		int[][] mark = new int[n][m];
		//read the matrix
		for(int i=0; i < n; i++){
			for(int j=0;j < m; j++){
				grap[i][j] = sc.nextInt();
			}
		}
		//line mark
		for(int i=0; i < n; i++){
			for(int j=0; j < m-2; j++){
				if(grap[i][j] == grap[i][j+1] && grap[i][j] == grap[i][j+2]){
					mark[i][j] = mark[i][j+1] = mark[i][j+2] = 1;
				}
			}
		}
		//row mark
		for(int i=0; i < n-2; i++){
			for(int j=0; j < m; j++){
				if(grap[i][j] == grap[i+1][j] && grap[i][j] == grap[i+2][j]){
					mark[i][j] = mark[i+1][j] = mark[i+2][j] = 1;
				}
			}
		}
		//convert
		for(int i=0;i < n; i++)
			for(int j=0; j < m; j++){
				if(mark[i][j] == 1){
					grap[i][j] = 0;
				}
			}
		//print
		for(int i=0; i < n; i++)
			for(int j=0; j < m; j++){
				if(j == m-1)
					System.out.print(grap[i][j] + "\n");
				else
					System.out.print(grap[i][j] + " ");
			}
	}
}
