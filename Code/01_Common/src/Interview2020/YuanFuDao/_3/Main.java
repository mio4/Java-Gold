package Interview2020.YuanFuDao._3;

import java.util.Scanner;

/**
 * 击鼓传花
 * 1. 结果需要% 1 0000 0000 7
 * 2. 从A开始传花，最后需要传回A，传N次
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        System.out.println(helper(N,K));
    }

    private static int helper(int N,int K){
        //递归终止条件
        if(N == 1){
            return 0;
        }
        if(N == 2 || N == 3){
            return (K-1);
        }

        //递归
        return helper(N-1,K)+helper(N-2,K);
    }
}
