package Interview2020.SenseTime._3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int ini = sc.nextInt();

        //尝试暴力计算
        dp = new int[year+1];
        dp[0] = ini;
        for(int i=1; i <= year; i++){
            int part1 = (a * helper(i-1))%1000000007;
            int part2 = (b * helper(i-2))%1000000007;
            int part3 = (c * helper(i-3))%1000000007;
            int part40 = (2*i)%1000000007;
            int part41 = (part40*i)%1000000007;
            int part42 = (part41-i)%1000000007;
            int part43 = (part42+32767)%1000000007;
            int part4 = part43;

            int p1 = (part1+part2)%1000000007;
            int p2 = (p1+part3)%1000000007;
            int p3 = (p2+part4)%1000000007;
            dp[i] = p3;
        }

        System.out.println(dp[year]);
    }

    private static int helper(int i){
        if(i < 0)
            return 0;
        return dp[i];
    }
}
