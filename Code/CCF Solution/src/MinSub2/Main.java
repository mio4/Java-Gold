package MinSub2;
//1 ： 使用二重循环直接进行求差对比最小值
//2 :  首先将所有数进行排序，然后相邻之间的数差值一定是最小的
import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		int i = 0;
		int nums[] = new int[1000];
		while(i < cnt){
			nums[i] = sc.nextInt();
			i++;
		}
		BubbleSort(nums,cnt);
		int min = 10001;
		for(int j=0;j < cnt-1;j++)
			if(abs(nums[j] -nums[j+1]) < min)
				min = abs(nums[j] - nums[j+1]);
		System.out.println(min);
	}

	public static void BubbleSort(int[] arr,int n){
		for(int i=0; i < n-1; i++){
			for(int j=0;j < n-i-1; j++){
				if(arr[j] > arr[j+1]){
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
	}

	public static int abs(int num){
		if(num >= 0)
			return num;
		else
			return (0-num);
	}
}
