package Num12_2;

public class Solution {
	public static boolean[][] visited = null;
	public static boolean hasPath(char[] matrix, int rows, int cols, char[] str)
	{
		if(matrix == null || rows < 1 || cols < 1 || str == null)
			return false;

		int PathLength = 0;
		visited = new boolean[rows][cols];
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				if(PathHelper(matrix,i,rows,j,cols,str,PathLength))
					return true;
			}
		}

		return false;
	}

	public static boolean PathHelper(char[] matrix, int i,int rows, int j,int cols,char[] str, int PathLength){
		if(PathLength == str.length)
			return true;

		boolean hasPath = false;
		if(i>=0 && i < rows && j >= 0 && j < cols && matrix[i*cols+j] == str[PathLength] && !visited[i][j]){ //找到了字符
			PathLength++;
			visited[i][j] = true;

			//接下来继续判断
			hasPath = PathHelper(matrix,i-1,rows,j,cols,str,PathLength)
					|| PathHelper(matrix,i+1,rows,j,cols,str,PathLength)
					|| PathHelper(matrix,i,rows,j-1,cols,str,PathLength)
					|| PathHelper(matrix,i,rows,j+1,cols,str,PathLength);

			if(!hasPath){
				PathLength--;
				visited[i][j] = false;
			}
		}

		//没有找到字符，返回false
		return hasPath;
	}

	public static void main(String[] args){
		char[] cs = {'a','b','t','g','c','f','c','s','j','d','e','h'};
		char[] str = {'b','f','c','e'};
		System.out.println(hasPath(cs,3,4,str));

		char[] cs2 = {'A','B','C','E','S','F','C','S','A','D','E','E'};
		char[] str2 = {'A','B','C','B'};
		System.out.println(hasPath(cs2,3,4,str2));
	}


}