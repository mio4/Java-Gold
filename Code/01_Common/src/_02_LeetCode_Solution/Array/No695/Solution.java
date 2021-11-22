package _02_LeetCode_Solution.Array.No695;

class Solution {
    private static boolean judge[][];
    public static int maxAreaOfIsland(int[][] grid) {
        int i,j;
        judge = new boolean[grid.length][grid[0].length];
        //for(i = 0; i < )
        return 0;
    }

    public static void main(String[] args){
        int a[][] =
                {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        System.out.println(maxAreaOfIsland(a));
    }
}
