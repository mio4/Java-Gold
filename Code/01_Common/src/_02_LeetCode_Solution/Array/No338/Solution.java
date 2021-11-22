package _02_LeetCode_Solution.Array.No338;

/**
 * 这是一道典型的面试算法题
 * （1）如何判断一个数中1的个数
 * （2）将0~n之间所有的数统计出来
 * 时间复杂度为O(N * logN)
 */
class Solution {
    public static int[] countBits(int num) {
        int[] res = new int[num+1];
        for(int i=0; i <= num; i++){
            res[i] = countOne(i);
        }
        return res;
    }

    private static int countOne(int num){
        int cnt = 0;
        while(num != 0){
            if(num%2 == 1){
                cnt++;
            }
            num = num/2;
        }
        return cnt;
    }

    public static void main(String[] args) {
        countBits(5);
    }
}