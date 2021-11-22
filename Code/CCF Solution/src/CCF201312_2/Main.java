package CCF201312_2;
//ISBN标志码
/*
	1.使用nexeLine读取下一行
	2.使用charAt提取String中的字符
	3.使用substring拼接字符串
 */
//如果没有考虑清楚sum==10的情况，只会有70分，部分输出结果不正确
import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int sum = 0;
		int mark = s.charAt(12)-'0';
		sum += (s.charAt(0)-'0')*1;
		sum += (s.charAt(2)-'0')*2;
		sum += (s.charAt(3)-'0')*3;
		sum += (s.charAt(4)-'0')*4;
		sum += (s.charAt(6)-'0')*5;
		sum += (s.charAt(7)-'0')*6;
		sum += (s.charAt(8)-'0')*7;
		sum += (s.charAt(9)-'0')*8;
		sum += (s.charAt(10)-'0')*9;
		sum %= 11;
		if(sum == mark){
			System.out.println("Right");
		} else if(sum == 10 && mark == 'X'-'0') {
			System.out.println("Right");
		} else{
			if(sum != 10)
				System.out.println(s.substring(0,12) + sum);
			else
				System.out.println(s.substring(0,12) + 'X');
		}
	}
}
