package _02_LeetCode_Solution.Array.No221;

/**
 * 暴力的方法挺难处理的
 * 听说可以使用DP动态规划
 */
class Solution {
    public static int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return 0;
        int maxArea = 0;
        int height = matrix.length;
        int width = matrix[0].length;
        int curArea = 0;
        for(int i=0; i < height; i++){
            for(int j=0; j < width; j++){
                int row = j+1, col = i+1;
                if(matrix[i][j] == '1') {
                    curArea = 1;
                    while (col < height && row < width && matrix[col][row - 1] == '1'
                            && matrix[col - 1][row] == '1' && matrix[col][row] == '1') {
                        curArea = (col - i + 1) * (col - i + 1);
                        col++;
                        row++;
                    }
                }
                maxArea = curArea > maxArea ? curArea : maxArea;
            }
        }
        return maxArea;
    }

    public static void main(String[] args){
        char[][] arr = {{'0','0','0','1'},{'1','1','0','1'},{'1','1','1','1'},
                {'0','1','1','1'},{'0','1','1','1'},};
        System.out.println(maximalSquare(arr));
    }
}
