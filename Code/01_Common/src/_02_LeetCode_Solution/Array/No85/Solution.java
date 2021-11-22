package _02_LeetCode_Solution.Array.No85;

/**
 * 朴素算法：时间复杂度为O(n^4)
 * 对于每一个点，从左往右，从上往下找到最大的矩形面积
 * （1）将对于每一个点的操作封装为函数
 * （2）遍历的时候，首先遍历一行，找到最小的width
 * （3）在遍历列的时候按照min_width进行计算
 */
class Solution {
    public static int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return 0;
        int max_area = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0; i < m; i++){
            for(int j=0; j < n; j++){
                max_area = Math.max(max_area,maxArea(matrix,i,j));
            }
        }
        return max_area;
    }

    public static int maxArea(char[][] matrix, int row, int col){
        int max_area = 0;
        int min_width = Integer.MAX_VALUE;
        for(int i=row; i < matrix.length && matrix[i][col] == '1'; i++){
            int width = 0;
            while(width + col < matrix[row].length && matrix[i][width+col] == '1')
                width++;
            if(width < min_width)
                min_width = width;
            max_area = Math.max(max_area,min_width*(i-row+1));
        }
        return max_area;
    }

    public static void main(String[] args){
        char[][] arr = {{'1','0','1','0','0'},{'1','0','1','1','1'},
                {'1','1','1','1','1'},{'1','0','0','1','0'}};
        maximalRectangle(arr);
    }
}
