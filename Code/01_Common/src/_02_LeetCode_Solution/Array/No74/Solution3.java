package _02_LeetCode_Solution.Array.No74;

/**
 * 将二维数组转换为一个升序的一维数组，使用二分查找，时间复杂度为O(log(columns*rows))
 * 使用二分查找，建立一个关于从二维数组映射到一维数组之间的函数关系
 * new_matrix[position] = matrix[position/n][position%n]
 * 易错点：
 * （1）考虑{{}}【只有一行，m=1，n=0】和{}【没有列 matirx[0]并不存在】的特殊情况
 * （2）二分查找的条件时left<=right,因为有可能在左右指针相遇的那个点才是最终想要的点
 */
class Solution3 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null)
            return false;
        if(matrix.length == 0 || matrix[0].length == 0)
            return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m*n-1;
        while(left <= right){
            int mid = (left+right)/2;
            if(matrix[mid/n][mid%n] == target)
                return true;
            else if(matrix[mid/n][mid%n] < target)
                left = mid+1;
            else
                right = mid-1;
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
        System.out.println(searchMatrix(matrix,3));
    }

}