package MiddleNumber;
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
		boolean find = false;
		for(int j=0; j < n; j++){
			int num = nums[j];
			int small = 0;
			int big = 0;
			for(int k=0; k < n; k++){
				if(nums[k] < num)
					small++;
				else if (nums[k] > num)
					big++;
			}
			if(small == big){
				System.out.println(num);
				find = true;
				break;
			}
		}
		if(!find)
			System.out.println(-1);
	}
}
