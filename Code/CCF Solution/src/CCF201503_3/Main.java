package CCF201503_3;
//节日
//闰年比平年多一天
//使用平行数组的方式不是一个好的方式，后面的代码除了数组不同之外很多重复
//但是数组必须要有两个
//所以其实构造判断方法是最好的方式，根据数组的不同
/*
	1.y1年的第一天是星期几
	2.a月的第一天是星期几
	3.第b个星期c是否合法，如果合法是第几天
	4.进行下一年的判断
 */
//能够通过测试样例
//运行错误：只有30分
import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int y1 = sc.nextInt();
		int y2 = sc.nextInt();
		int[] pm = {31,28,31,30,31,30,31,31,30,31,30,31};
		int[] rm = {31,29,31,30,31,30,31,31,30,31,30,31};

		//0表示星期一，6表示星期天
		//首先计算y1的第一天是星期几
		int days = 0; //days:计算星期的变量
		for(int i=1850; i < y1; i++){
			if(is_leap(i))
				days += 366;
			else
				days += 365;
		}
		days %= 7;
		//然后从y1年开始计算
		for(int i=y1; i <= y2; i++){
			int days2 = days;
			if(is_leap(i)) {
				for(int k = 0; k < a-1; k++) {
					days2 += rm[i];
				}
				days2 %= 7;
				int cnt = (b-1)*7;
				for(int k=0; k < 7; k++){ //最后一个星期进行判断
					days2 = (days2 + 1) % 7;
					cnt++;
					if(cnt > rm[a-1]){
						System.out.println("none");
					} else{
						if(days2 == c-1){
							System.out.format("%d/%02d/%02d\n",i,a,cnt);
						}
					}
				}
			} else{
				for(int k=0; k < a-1; k++){
					days2 += pm[k];
				}
				days2 %= 7; //计算a月的第一天是星期几5 2 7 2014 2015
				int cnt = (b-1)*7;
				for(int k=0; k < 7; k++){ //最后一个星期进行判断
					days2 = (days2 + 1) % 7;
					cnt++;
					if(cnt > rm[a-1]){
						System.out.println("none");
					} else{
						if(days2 == c-1){
							System.out.format("%d/%02d/%02d\n",i,a,cnt);
						}
					}
				}
			}
		//累计今年的日子
			if(is_leap(i))
				days += 366;
			else
				days += 365;
		}
	}
	public static boolean is_leap(int year){
		if(year%400==0 || (year%4==0 && year%100!=0))
			return true;
		return false;
	}
}
