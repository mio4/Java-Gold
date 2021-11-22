package TurningPoint;
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
		for(i=1;i < n-1;i++){
			if((nums[i] < nums[i-1] && nums[i] < nums[i+1]) || (nums[i] > nums[i-1] && nums[i] > nums[i+1]))
				cnt++;
		}
		System.out.println(cnt);
	}
}
