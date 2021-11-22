package StudentQueue;
//数据结构：数组
//模拟队列中的移动
//Bug : 对于元素的后移和前移没有想清楚
import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] persons = new int[n];
		for(int i=0; i < n;i++){
			persons[i] = i+1;
		}
		int m_cnt = 0;
		while(m_cnt < m){
			int person = sc.nextInt();
			int adjust = sc.nextInt();
			int pos = -1;
			if(adjust > 0){
				//find person
				for(int i=0;i < n;i++){
					if(persons[i] == person){
						pos = i;
						break;
					}
				}
				//change
				for(int i=pos; i < pos+adjust; i++){
					persons[i] = persons[i+1];
				}
				persons[pos+adjust] = person;
			} else if (adjust < 0){
				//find person
				for(int i=0;i < n;i++){
					if(persons[i] == person){
						pos = i;
						break;
					}
				}
				//change
				for(int i=pos; i > pos+adjust; i--){
					persons[i] = persons[i-1];
				}
				persons[pos+adjust] = person;
			} else {
				//do nothing
			}
			m_cnt++;
		}
		for(int i=0;i < n; i++){
			if(i == n-1)
				System.out.print(persons[i]);
			else
				System.out.print(persons[i] + " ");
		}
	}
}
