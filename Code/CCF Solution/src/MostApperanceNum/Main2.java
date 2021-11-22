package MostApperanceNum;
//hint:对于si数的范围进行了限制，所以可以直接使用数组作为计数器
//相对于构造类来单独存储的方式，代码简化了将近一半，并且更加清晰
import java.util.Scanner;
public class Main2 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] counts = new int[10001];
		int i = 0;
		while(i < n){
			counts[sc.nextInt()]++;
			i++;
		}
		int time = 0;
		int num = 0;
		for(int j=1; j < 10001; j++){
			if(counts[j] > time){
				time = counts[j];
				num = j;
			}
		}
		System.out.println(num);
	}
}
