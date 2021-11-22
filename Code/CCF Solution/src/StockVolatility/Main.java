package StockVolatility;
import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		int i = 0;
		while(i < n){
			nums[i] = sc.nextInt();
			i++;
		}
		int max = 0;
		for(i = 0;i < n-1; i++){
			if(abs(nums[i] - nums[i+1]) > max)
				max = abs(nums[i] - nums[i+1]);
		}
		System.out.println(max);

	}
	public static int abs(int x){
		if(x <= 0)
			return -x;
		else
			return x;
	}
}
