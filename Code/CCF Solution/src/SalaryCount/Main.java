package SalaryCount;
//这道题需要重点说明一下，题目本身并不困难，但是最开始走了一些弯路导致花费时间很长
//首先要意识到使用程序计算比较保险(手写的话也行，不过容易混乱)，但是比较繁琐，所以要标注好变量
//其次，最花费时间的是对于税后工资的组成部分进行分析以及逆向计算的过程
//工资 = 不交税部分 + 交税部分
//交税部分 = (0-1500)段 + (1500-4500)段 + ...
//对于某一段位的工资，前面段都是固定已知税，所以首先计算出最后一段不确定的工资
//然后将每一段的工资相加即可
//**解题重点在于分段计算**
import java.util.Scanner;
public class Main {
	public static void main(String[] arg){
		Scanner sc = new Scanner(System.in);
		int after_tax = sc.nextInt(); //税后工资
		int before_tax = 0; //税前工资

		//每个段的税
		double l1 = 0;
		double l2 = 1500 * 0.03;
		double l3 = (4500-1500) * 0.1;
		double l4 = (9000-4500) * 0.2;
		double l5 = (35000-9000) * 0.25;
		double l6 = (55000-35000) * 0.3;
		double l7 = (80000-55000) * 0.35;

		//交税之后剩余
		double a1 = 0-l1;
		double a2 = 1500 - l2;
		double a3 = 4500 - l2 - l3;
		double a4 = 9000 - l2 - l3 - l4;
		double a5 = 35000 - l2 - l3 - l4 - l5;
		double a6 = 55000 - l2 - l3 - l4 - l5 - l6;
		double a7 = 80000 - l2 - l3 - l4 - l5 - l6 - l7;

		double b3,b4,b5,b6,b7,b8;

		double tax_money =  (double) (after_tax - 3500); //交税部分剩下来的工资
		if(tax_money <= a1){
			before_tax = after_tax;
		} else if (tax_money <= a2){
			before_tax = (int) (3500 + tax_money / 0.97);
		} else if (tax_money <= a3){
			//before_tax = (int) (3500 + (tax_money + 45) / 0.9);
			b3 = (tax_money - (1500 - l2)) / 0.9;
			before_tax = (int) (3500 + 1500 + b3);
		} else if (tax_money <= a4){
			b4 = (tax_money - (1500 - l2) - (3000 - l3)) / 0.8;
			before_tax = (int) (3500 + 1500 + 3000 + b4);
		} else if (tax_money <= a5){
			b5 = (tax_money - (1500-l2) - (3000-l3) - (4500-l4)) / 0.75;
			before_tax = (int) (3500 + 1500 + 3000 + 4500 + b5);
		} else if (tax_money <= a6){
			b6 = (tax_money - (1500-l2) - (3000-l3) - (4500-l4) - (26000-l5)) / 0.7;
			before_tax = (int) (3500 + 1500 + 3000 + 4500 + 26000 + b6);
		} else if (tax_money <= a7){
			b7 = (tax_money - (1500-l2) - (3000-l3) - (4500-l4) - (26000-l5) - (20000 - l6)) / 0.65;
			before_tax = (int) (3500 + 1500 + 3000 + 4500 + 26000 + 20000 + b7);
		} else {
			b8 = (tax_money - (1500-l2) - (3000-l3) - (4500-l4) - (26000-l5) - (20000-l6) - (25000-l7)) / 0.55;
			before_tax = (int) (3500 + 1500 + 3000 + 4500 + 26000 + 20000 + 25000 + b8);
		}

		System.out.println(before_tax);
	}
}
