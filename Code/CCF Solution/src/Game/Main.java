package Game;
//第一次出现Bug：在对于pos的更新，应该是处于n+1越界的时候手动调整到1，处于n的情况还是需要处理
import java.util.Scanner;
import java.util.Arrays;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int cnt = 0; //计数君
		int pos = 1; //小朋友编号
		int left = n; //剩余人数
		boolean[] arr = new boolean[n+1];
		Arrays.fill(arr,true);
		while(true){
			if(arr[pos]) {
				cnt++;
				if (cnt % k == 0 || cnt % 10 == k) {
					arr[pos] = false;
					left--;
				}
				if (left == 1)
					break;
			}
			pos++;
			if(pos == n+1)
				pos = 1;
		}
		for(int i=1;i <= n; i++)
			if(arr[i])
				System.out.println(i);
	}
}
