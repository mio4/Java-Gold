package _02_LeetCode_Solution.Interview._54;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] isSeen = new boolean[m][n];
        int[] dx = {0,1,0,-1};
        int[] dy = {-1,0,1,0};
        List<Integer> res = new ArrayList<>();

        int x = -1, y = 0, d = 1;
        int left = 0, right = n-1, top = 0, bottom = m-1;
        for(int i=0; i < m * n; ){
            x = x + dx[d]; //更新坐标
            y = y + dy[d];

            //1.要么触碰到数组边界 2. 要么是已经遍历的元素
            if(!(x >= left && x <= right && y >= top && y <= bottom) || isSeen[y][x] ){
                if(x > right) x--;
                else if(x < left)  x++;
                else if(y < top)   y++;
                else if(y > bottom)y--;
                d = (d + 1) % 4;
            }
            else{
                res.add(matrix[y][x]);
                isSeen[y][x] = true;
                i++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
//        int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
//        System.out.println(spiralOrder(a));

        int[][] b = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println(spiralOrder(b));
    }
}
