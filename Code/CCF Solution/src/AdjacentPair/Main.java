package AdjacentPair;
//冒泡排序：用起来就是舒服
//tips:直接使用Ararys.sort(nums)进行排序，时间效率更高
import java.util.Arrays;
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
		//Arrays.sort(nums,0,n);
		//BubbleSort(nums,n);
		Arrays.sort(nums);
		int cnt = 0;
		for(int j=0; j < n-1; j++)
			if(nums[j+1]-nums[j] == 1)
				cnt++;
		System.out.println(cnt);

	}
	public static void BubbleSort(int[] nums, int n){
		for(int i=0;i < n; i++)
			for(int j=0; j < n-i-1; j++){
				if(nums[j] > nums[j+1]){
					int tmp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = tmp;
				}
			}
	}
}
