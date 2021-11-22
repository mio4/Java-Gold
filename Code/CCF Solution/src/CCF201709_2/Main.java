package CCF201709_2;
//公共钥匙盒
//难点：如果有多位老师还钥匙，则他们按钥匙编号从小到大的顺序还。
//Problem:算法上看似没有问题，能够通过2个评测样例，但是只有20分
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		Teacher[] teachers = new Teacher[K];
		int[] boxs = new int[N + 1];
		for (int j = 0; j < N + 1; j++)
			boxs[j] = j;
		int i = 0;
		while (i < K) {
			int key = sc.nextInt();
			int s_time = sc.nextInt();
			int time = sc.nextInt();
			teachers[i] = new Teacher(key, s_time, time);
			i++;
		}
		//模拟时间运行
		int min_time = 10100;
		int max_time = 0;
		for (int j = 0; j < K; j++) {
			if (teachers[j].s_time < min_time)
				min_time = teachers[j].s_time;
			if (teachers[j].e_time > max_time)
				max_time = teachers[j].e_time;
		}
		for (int t = min_time; t <= max_time; t++) {
			//首先看有没有还钥匙的
			ArrayList<Integer> list1 = new ArrayList<Integer>();
			for (int j = 0; j < K; j++) {
				if(teachers[j].e_time == t) {
					list1.add(teachers[j].key);
				}
			}
			if(list1.size() != 0){
				int[] arr1 = new int[list1.size()];
				copyArr(list1,arr1,list1.size());
				BubbleSort(arr1,list1.size());
				ReturnKey(arr1,list1.size(),boxs,N);
			}
			//再看有没有借钥匙的
			for(int j=0; j < K; j++){
				if(teachers[j].s_time == t){
					for(int k=0; k <= N; k++){
						if(boxs[k] == teachers[j].key)
							boxs[k] = -1;
					}
				}
			}
		}

		for(int k=1; k <= N; k++){
			if(k != N)
				System.out.print(boxs[k] + " ");
			else
				System.out.print(boxs[k]);
		}
	}

	public static void BubbleSort(int arr[], int n){
		for(int i=0;i < n; i++)
			for(int j=0; j < n-1-i; j++){
				if(arr[j] < arr[j+1]){
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
	}

	public static void copyArr(ArrayList<Integer> list, int[] arr, int n){
		for(int i = 0; i < n; i++)
			arr[i] = list.get(i);
	}

	public static void ReturnKey(int[] arr, int n,int[] boxs, int N){
		int cnt = 0;
		for(int i=1;i <= N; i++)
			if(boxs[i] == -1){
				boxs[i] = arr[cnt++];
				if(cnt == n)
					break;
			}
	}
}

class Teacher{
	public int key;
	public int s_time;
	public int time;
	public int e_time;
	public Teacher(int key,int s_time,int time){
		this.key = key;
		this.s_time = s_time;
		this.time = time;
		this.e_time = s_time + time;
	}
}
