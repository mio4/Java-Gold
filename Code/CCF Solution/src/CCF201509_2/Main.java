package CCF201509_2;
//日期计算
//Tips:平年的2月有28天，闰年的2月有29天
//Problem:只有90分，不知道哪一个点挂掉了...
import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int y = sc.nextInt();
		int d = sc.nextInt();

		int[] months = {31,28,31,30,31,30,31,31,30,31,30,31};
		if((y%4==0 && y%100!=0) || y%400==0)
			months[1] = 29;
		int days = 0;
		int cnt1=0;
		int cnt2=0;
		for(int i=0;i < 12; i++){
			days += months[i];
			if(days > d){
				cnt1 = i+1;
				break;
			}
		}
		for(int i=0;i < cnt1-1; i++){
			d-=months[i];
		}
		cnt2 = d;
		System.out.println(cnt1);
		System.out.println(cnt2);
	}
}
