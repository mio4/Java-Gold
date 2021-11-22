package MinSub;
//第一次Bug原因：i++应放在while循环内部
import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		int i = 0;
		int min = 10001;
		int[] nums = new int[1000];
		while(i < cnt){
			nums[i] = sc.nextInt();
			i++;
		}
		for(int j=0;j < cnt-1; j++)
			for(int k=j+1; k < cnt; k++){
				int x = getPosi(nums[j] - nums[k]);
				if(x < min)
					min = x;
			}
		System.out.println(min);
	}

	public static int getPosi(int num){
		if(num >= 0)
			return num;
		else
			return (0-num);
	}
}
