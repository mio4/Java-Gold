package _02_LeetCode_Solution.Array.No74;

/**
 * 74. Search a 2D Matrix
 * 朴素算法，遍历所有的数即可
 */
class Solution {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null)
            return false;
        int m = matrix.length;
        if(m == 0)
            return false;
        int n = matrix[0].length;
        for(int i=0; i < m; i++)
            for(int j=0; j < n; j++){
                if(matrix[i][j] == target)
                    return true;
                else if(matrix[i][j] > target)
                    return false;
            }

            return false;
    }

    public static void main(String[] args){
        int[][] matrix ={
                            {1,   3,  5,  7},
                            {10, 11, 16, 20},
                            {23, 30, 34, 50}
                        };

        int[][] matrix2 = {};
        System.out.println(searchMatrix(matrix2,0));
    }
}
