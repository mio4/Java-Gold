package EntranceGuard;
import java.util.Scanner;
import java.util.ArrayList;
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
		ArrayList<person> persons = new ArrayList<person>();
		for(i=0; i < n; i++){
			boolean flag = false;
			for(int j=0; j < persons.size(); j++){
				if(persons.get(j).num == nums[i]){
					persons.get(j).cnt++;
					System.out.print(persons.get(j).cnt + " ");
					flag = true;
					break;
				}
			}
			if(!flag){
				persons.add(new person(nums[i]));
				System.out.print(1 + " ");
			}
		}
	}
}
class person {
	public int num;
	public int cnt;
	public person(int num){
		this.num = num;
		this.cnt = 1;
	}
}
