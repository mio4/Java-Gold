package CCF201403_2;
//窗口
//如果点击到多个窗口，将最上面的置于顶层
//如果没有点击到窗口，忽略
//Bug:每个窗口属性有：坐标以及输入的相对顺序，最后输出的是窗口的固有属性，是绝对属性，而不是输出数组中的相对属性
//面向对象：一切皆对象
import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		Rec[] recs = new Rec[n];
		for(int i=0; i < n; i++) {
			recs[i] = new Rec(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
			recs[i].cnt = i+1;
		}
		int[][] mouses = new int[m][2];
		for(int i=0; i < m; i++) {
			mouses[i][0] = sc.nextInt();
			mouses[i][1] = sc.nextInt();
		}
		//click
		for(int i=0; i < m; i++) {
			int cnt = -1;
			int num = -1;
			int j;
			for(j=0; j < n; j++){
				if(mouses[i][0]>=recs[j].x1 && mouses[i][0]<=recs[j].x2 && mouses[i][1]>=recs[j].y1 && mouses[i][1]<=recs[j].y2){
					cnt = j;
					num = recs[j].cnt;
				}
			}
			if(cnt == -1){
				System.out.println("IGNORED");
			} else{
				System.out.println(num);
				Rec rec = recs[cnt];
				for(int k=cnt; k < n-1; k++){
					recs[k] = recs[k+1];
				}
				recs[n-1] = rec;
			}
		}
	}
}
class Rec {
	public int cnt;
	public int x1;
	public int y1;
	public int x2;
	public int y2;
	public Rec(int x1,int y1, int x2, int y2){
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
}
