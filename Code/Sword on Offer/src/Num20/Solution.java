package Num20;

import java.util.ArrayList;
public class Solution {
	public static ArrayList<Integer> printMatrix(int [][] matrix) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int NORTH = 0;
		int EAST = 0;
		int SOUTH = 0;
		int WEST = 0;
		int flag = 1;
		int cnt = 0;
		int n = matrix.length; //行数
		int m = matrix[0].length; //列数
		int i = 0;
		int j = 0;
		while(cnt < m*n){
			if(flag == 1){
				for(j=WEST; j < m-EAST; j++) {
					result.add(matrix[i][j]);
					cnt++;
				}
				j--;
				i++;
				NORTH++;
				flag = 2;
			} else if(flag == 2){
				for(i=NORTH; i < n-SOUTH; i++){
					result.add(matrix[i][j]);
					cnt++;
				}
				i--;
				j--;
				EAST++;
				flag = 3;
			} else if(flag == 3){
				for(j=m-EAST-1; j >= WEST ;j--){
					result.add(matrix[i][j]);
					cnt++;
				}
				j++;
				i--;
				SOUTH++;
				flag = 4;
			} else if(flag == 4){
				for(i=n-SOUTH-1; i >= NORTH; i--){
					result.add(matrix[i][j]);
					cnt++;
				}
				i++;
				j++;
				WEST++;
				flag = 1;
			}
		}
		return result;
	}

	public static void main(String[] args){
		int[][] a = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		ArrayList<Integer> res = printMatrix(a);
		int n = a.length;
		int m = a[0].length;
		for(int i=0; i < m; i++)
			System.out.println(a[0][i]);
		for(int i=m-1; i >= 0; i--)
			System.out.println(a[0][i]);
	}
}
