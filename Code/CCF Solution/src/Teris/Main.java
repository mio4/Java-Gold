package Teris;
import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int[][] grap = new int[15][10];
		int g_cnt = 0;
		int m = 0;
		int n = 0;
		//read the graph
		while(g_cnt < 150){
			grap[m][n++] = sc.nextInt();
			if(n == 10){
				n = 0;
				m++;
			}
			g_cnt++;
		}
		//read the box
		int[][] box = new int[4][4];
		int b_cnt = 0;
		m = 0;
		n = 0;
		while(b_cnt < 16){
			box[m][n++] = sc.nextInt();
			if(n == 4){
				n = 0;
				m++;
			}
			b_cnt++;
		}
		//read the shift
		int shift = sc.nextInt();
		//judge
		int down_line = 0;
		OUT1:
		for(int i=0; i <= 11; i++){
			for(int j=0;j < 4; j++){
				for(int k=0; k < 4; k++){
					if(box[j][k] == 1 && grap[i][shift - 1 + k] == 1)
						break OUT1;
				}
			}
			down_line = i;
		}
		//change
		//System.out.println(down_line);
		for(int i=0;i < 4;i++)
			for(int j=0; j < 4;j++){
				if(box[i][j] == 1){
					grap[i+down_line+1][shift + j - 1] = 1;
				}
			}

		//print
		for(int i=0; i < 15; i++){
			for(int j=0; j < 10; j++){
				if(j == 9)
					System.out.print(grap[i][j] + "\n");
				else
					System.out.print(grap[i][j] + " ");
			}
		}
	}
}
