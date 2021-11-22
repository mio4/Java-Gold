package CCF201503_2;
//数字排序
//构造Num对象，规定对象相对大小，使用冒泡排序
//获取输入 输入处理 输出结果
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
			for(int j=0;j < nums.size(); j++){
				if(nums.get(j).num == x){
					nums.get(j).cnt++;
					flag = true;
					break;
				}
			}
			if(flag == false){
				nums.add(new Num(x));
			}
			i++;
		}
		//copy
		Num[] nums2 = new Num[nums.size()];
		for(int j=0; j < nums.size(); j++)
			nums2[j] = nums.get(j);
		BubbleSort(nums2,nums.size());
		for(int j=0; j < nums.size(); j++){
			System.out.println(nums2[j].num + " " + nums2[j].cnt);
		}
	}

	//实质：规定不同Num对象之间的相对大小：
	public static void BubbleSort(Num[] nums, int n){
		for(int i=0; i < n;i++)
			for(int j=0; j < n-i-1; j++){
				if(nums[j].cnt < nums[j+1].cnt){ //出现次数小的放在后面
					Num tmp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = tmp;
				}
				if(nums[j].cnt == nums[j+1].cnt && nums[j].num > nums[j+1].num){ //出现次数相同，值越大的在后面
					Num tmp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = tmp;
				}
			}
	}
}
class Num{
	public int num;
	public int cnt;
	public Num(int num){
		this.num = num;
		this.cnt = 1;
	}
}
