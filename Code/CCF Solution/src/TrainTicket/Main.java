package TrainTicket;
//Java中一切皆对象，所以对于每一排的情况进行封装
//首先考虑能够连坐的情况
//然后考虑不能连坐的情况
//过程中容易出现问题的就是对于Row的属性没有进行及时的更新
//习惯：首先搭建框架，再进行具体代码填充
import java.util.Scanner;
import java.util.Arrays;
public class Main {
	public static void main(String[] args){
		Scanner  sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] ins = new int[n];
		int i = 0;
		while(i < n){
			ins[i] = sc.nextInt();
			i++;
		}
		Row[] rows = new Row[20];
		for(i=0; i < 20; i++){
			rows[i] = new Row(i);
		}
		//deal
		for(i=0; i < n; i++){
			boolean deal = false;
			int persons = ins[i];
			for(int j=0; j < 20; j++){
				//能够连坐的情况
				if(rows[j].left >= persons){
					rows[j].left -= persons;
					deal = true;
					for(int k=0; k < 5;k++){
						if(rows[j].s[k]){
							rows[j].s[k] = false;
							persons--;
							if(persons == 0)
								System.out.print((rows[j].num*5 + k + 1) + "\n");
							else
								System.out.print((rows[j].num*5 + k + 1) + " ");
							if(persons == 0)
								break;
						}
					}
					break;
				}
			}
			//不能连坐的情况
			if(!deal){
				for(int j=0;j < 20;j++){
					for(int k=0; k < 5; k++){
						if(rows[j].s[k]==true && persons!=0){
							persons--;
							rows[j].s[k] = false;
							if(persons == 0)
								System.out.print((rows[j].num*5 + k + 1) + "\n");
							else
								System.out.print((rows[j].num*5 + k + 1) + " ");
						}
					}
				}
			}
		}
	}
}
class Row {
	public boolean s[] = new boolean[5];
	public int num;
	public int left;
	public Row(int num){
		this.num = num;
		this.left = 5;
		Arrays.fill(s,true);
	}

}
