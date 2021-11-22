package _02_LeetCode_Solution.Array.No440;

/**
 * TODO 这道题真的需要好好算算
 * TODO 自己实现一遍算法的过程
 * https://blog.csdn.net/gqk289/article/details/62039153
 * https://blog.csdn.net/qq_36946274/article/details/81638367
 *
 */
public class Solution2 {
    public static int findKthNumber(int n, int k) {
        int cur = 1;
        int step;
        k--;
        while (k > 0) {
            step = calStep(n, cur, cur + 1);
            if (step <= k) {
                k -= step;
                cur++;
            } else {
                k--;
                cur *= 10;
            }
        }
        return cur;
    }
    private static int calStep(int n, long n1, long n2) {
        int step = 0;
        while (n1 <= n) {
            step += Math.min(n + 1, n2) - n1;
            n1 *= 10;
            n2 *= 10;
        }
        return step;
    }

    public static void main(String[] args){
        System.out.println(findKthNumber(200,5));
        System.out.println(findKthNumber(200,6));
    }

}

