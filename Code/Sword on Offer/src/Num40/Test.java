package Num40;

public class Test {
	public static void main(String[] args){
		int[] arr = {1,4,5,8,2,3,9,10};
		quickSort(arr,0,7); //left指数组的左边界，right指数组的右边界
		for(int i=0; i < 8; i++)
			System.out.println(arr[i]);
	}
	public static void quickSort(int[] arr,int left, int right){
		int x = arr[left];
		int i = left;
		int j = right;
		while(i != j){
			while(arr[j] >= x && i < j)
				j--;
			while(arr[i] <= x && i < j)
				i++;
			//对于这两个数进行交换
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		//i和j相等时，将x和中间值交换
		arr[left] = arr[i];
		arr[i] = x;

		//进行分治,首先要求数组有意义，才有必要对其进行递归操作
		if(i-1 > left)
			quickSort(arr,left,i-1);
		if(i+1 < right)
			quickSort(arr,i+1,right);
	}
}
