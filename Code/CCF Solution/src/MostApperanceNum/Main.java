package MostApperanceNum;
//使用类-结构体来存储数和对应出现的次数
//解题过程比较繁琐，尝试进行简化
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Num> nums = new ArrayList<Num>();
		int i = 0;
		while(i < n){
			boolean flag = false;
			int x = sc.nextInt();
			for(int j=0; j < nums.size(); j++){
				if(nums.get(j).num == x){
					nums.get(j).cnt++;
					flag = true;
					break;
				}
			}
			if(!flag){
				nums.add(new Num(x));
			}
			i++;
		}
		int time = 0;
		int num = 0;
		for(int j=0; j < nums.size(); j++){
			if(nums.get(j).cnt > time){
				time = nums.get(j).cnt;
				num = nums.get(j).num;
			}
			else if(nums.get(j).cnt == time){
				if(num > nums.get(j).num)
					num = nums.get(j).num;
			}
		}
		System.out.println(num);
	}
}
class Num {
	public int num; //存储的数
	public int cnt; //数出现的次数
	public Num(int num){
		this.num = num;
		this.cnt = 1;
	}
}
