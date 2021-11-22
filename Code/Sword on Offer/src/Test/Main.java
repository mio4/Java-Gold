package Test;
//实现了一个快速排序算法
//算法有几个需要关注的点
public class Main {
	public static void main(String[] args){
		int[] a = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
		quickSort(a,0,9);
		for(int i=0; i < 10; i++)
			System.out.println(a[i]);
	}

	public static void quickSort(int[] a, int left, int right){
		int i,j,tmp;
		if(left > right)
			return;
		tmp = a[left];
		i = left;
		j = right;

		while(i != j){
			while(a[j] >= tmp && i != j)
				j--; //找到的a[j] < tmp
			while(a[i] <= tmp && i != j)
				i++; //找到的a[i] > tmp
			int t = a[i];
			a[i] = a[j];
			a[j] = t;
		}

		//i == j 时
		a[left] = a[i];
		a[i] = tmp;

		//recur
		quickSort(a,left,i-1);
		quickSort(a,i+1,right);
	}
}
