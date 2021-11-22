package ArraySection;
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

		if(n == 1){
			System.out.println(1);
		} else{
			int cnt = 1;
			int before = nums[0];
			for(int j=1; j < n; j++){
				if(nums[j] != before){
					cnt++;
					before = nums[j];
				}
			}
			System.out.println(cnt);
		}
	}
}
