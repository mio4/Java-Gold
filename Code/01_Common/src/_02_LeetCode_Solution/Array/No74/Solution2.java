package _02_LeetCode_Solution.Array.No74;

/**
 * 使用二分查找
 * 难点：对于边界条件的考虑
 * Runtime Error
 */
class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null)
            return false;
        int m = matrix.length;
        if(m == 0)
            return false;
        int n = matrix[0].length;
        if(n == 0)
            return false;
        int i = 0, j = 0;
        while(i < m || j < n){
            //退出条件
            if(matrix[i][j] > target)
                return false;
            else if(matrix[i][j] == target)
                return true;
            if(i+1 >= m)
                j++;
            else if(j+1 >= n)
                i++;
            if(i >= m || j >= n)
                return false; //完成了所有的查找

            if(j+1 >= n && i+1 >= m)
                return false;
            int right = matrix[i][j+1];
            int down = matrix[i+1][j];
            if(down <= target && right <= target)
                i++;
            else if(down >= target && right <= target)
                j++;
            else
                return false;
        }
        return false;
    }
}
