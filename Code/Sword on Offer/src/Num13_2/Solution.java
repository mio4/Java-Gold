package Num13_2;

public class Solution {
	public static int count = 0;
	public static boolean visited[][];
	static int i = 0;
	static int j = 0;
	static int m_rows;
	static int m_cols;
	public static  int movingCount(int threshold, int rows, int cols)
	{
		m_rows = rows;
		m_cols = cols;
		visited = new boolean[rows][cols];
		Moving(threshold,i,j);
		return count;
	}

	public static void Moving(int threshold, int i, int j){
		if(!isMoreK(threshold,i,j)  && i >= 0 && i < m_rows && j >= 0 && j < m_cols && !visited[i][j]) { //位数和小于k，在矩阵内,没有被访问过
			count++;
			visited[i][j] = true;
			Moving(threshold, i, j + 1);
			Moving(threshold, i, j - 1);
			Moving(threshold, i - 1, j);
			Moving(threshold, i + 1, j);
		}
	}

	public static boolean isMoreK(int k, int i, int j){ //判断i和j的位数和是否大于K
		int cnt = 0;
		while(i != 0){
			cnt += i%10;
			i /= 10;
		}
		while(j != 0){
			cnt += j%10;
			j /= 10;
		}
		return (cnt > k);
	}

	public static void main(String[] args){
		System.out.println(movingCount(15,20,20));
	}
}
