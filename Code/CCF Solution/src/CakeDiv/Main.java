package CakeDiv;
//Bug1 : 对于cake的used属性没有及时更新
//Bug2 : 笔误，i变量和j变量
import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		Cake[] cakes = new Cake[n];
		int i = 0;
		while(i < n){
			cakes[i] = new Cake(sc.nextInt());
			i++;
		}
		int cake_cnt = 0;
		int cake_weight = 0;
		int persons = 0;
		while(cake_cnt < n){
			for(int j=0;j < n;j++){
				if(cakes[j].used == false){
					cake_weight += cakes[j].weight;
					cakes[j].used = true;
					cake_cnt++;
				}
				if(cake_weight >= k){
					break;
				}
			}
			cake_weight = 0;
			persons++;
		}
		System.out.println(persons);
	}
}
class Cake {
	public boolean used;
	public int weight;
	public Cake(int weight){
		this.weight = weight;
		used = false;
	}
}
