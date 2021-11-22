package Interview2020.SenseTime._3;

import java.util.Scanner;

public class Main3 {
    private static long[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int ini = sc.nextInt();

        //尝试暴力计算
        dp = new long[year+1];
        dp[0] = ini;
        for(int i=1; i <= year; i++){
            dp[i] = (a*helper(i-1)+b*helper(i-2)+c*helper(i-3)+2*i*i-i+32767)%1000000007;
        }

        System.out.println(dp[year]);
    }

    private static long helper(int i){
        if(i < 0)
            return 0;
        return dp[i];
    }
}
