package OppositeNum;
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
		int cnt = 0;
		for(int j=0;j < n-1; j++)
			for(int k=j+1; k < n; k++)
				if(nums[j] + nums[k] == 0)
					cnt++;
		System.out.println(cnt);
	}
}
