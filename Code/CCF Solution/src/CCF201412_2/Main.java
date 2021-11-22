package CCF201412_2;
//Z字型扫描
//分析以后看似文件比较简单，但是采坑之后花了四五十分钟才解决
import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] m = new int[n][n];
		for(int i=0; i < n; i++)
			for(int j=0; j < n; j++)
				m[i][j] = sc.nextInt();

		int cnt = n*n;
		int i = 0;
		int j = 0;
		int flag = 1;
		while(cnt > 0){
			System.out.print(m[i][j] + " ");
			//next point
			if(flag == 1){
				j++;
			} else if(flag == 2){
				i++;
				j--;
			} else if(flag == 3){
				i++;
			} else if(flag == 4){
				i--;
				j++;
			}
			//change flag
			if(flag == 1){
				if(i == 0)
					flag = 2;
				else if(i == n-1)
					flag = 4;
			} else if(flag == 2){
				if(i!=n-1 && j==0)
					flag = 3;
				else if(i == n-1)
					flag = 1;
			} else if(flag == 3){
				if(j == 0)
					flag = 4;
				else if(j == n-1)
					flag = 2;
			} else if(flag == 4){
				if(j!=n-1 &&i==0)
					flag = 1;
				else if(j == n-1)
					flag = 3;
			}
			cnt--;
		}
	}
}
