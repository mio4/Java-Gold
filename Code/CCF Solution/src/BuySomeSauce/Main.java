package BuySomeSauce;
//这道题实在太简单了，就是考普通的数据输入和数据处理输出
//sc.nextInt()函数真的是好用
import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		int num = money / 10;
		int num5 = num / 5;
		int num3 = (num - num5*5) / 3;
		int num1 = num - num5*5 - num3*3;
		int sum = (num5 * 7) + (num3 * 4) + num1;
		System.out.println(sum);
	}
}
