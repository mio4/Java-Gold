package Interview2017.wangyi.No2;

/**
 * https://www.nowcoder.com/practice/5a0a2c7e431e4fbbbb1ff32ac6e8dfa0?tpId=85&tqId=29848&tPage=1&rp=1&ru=/ta/2017test&qru=/ta/2017test/question-ranking
 * 我觉得没有问题
 * 题目的输入根本看不懂
 * ...
 */

import java.util.Scanner;
import java.util.Arrays;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i=0; i < T; i++){
            int n = in.nextInt();
            int k = in.nextInt();
            //0.获取输入
            int[] origin = new int[2*n];
            int[] res = new int[2*n];
            for(int j=0; j < 2*n; j++)
                origin[j] = in.nextInt();
            //1.洗牌
            int oriIdx = 0, resIdx = 0;
            while(k > 0){
                for(int j = 2*n-1; j >= n; j--){
                    res[resIdx] = origin[j];
                    resIdx += 2;
                }
                resIdx = 1;
                for(int j = n-1; j >= 0; j--){
                    res[resIdx] = origin[j];
                    resIdx += 2;
                }
                origin = Arrays.copyOf(res,2*n);
                k--;
            }
            //2.输出洗牌后的顺序
            for(int j=2*n-1; j >= 0; j--){
                if(j != 0)
                    System.out.print(res[j] + " ");
                else
                    System.out.println(res[j]);
            }
        }
    }
}
