package Interview2017.wangyi.No7;
/**
 * https://www.nowcoder.com/practice/cd763d8541fc4243b8d3b967bb6d6b6a?tpId=85&tqId=29841&tPage=1&rp=1&ru=/ta/2017test&qru=/ta/2017test/question-ranking
 */

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] traps = new int[n][2];
        //1.获取输入
        for(int i=0; i < n; i++){
            traps[i][0] = in.nextInt();
        }
        for(int i=0; i < n; i++){
            traps[i][1] = in.nextInt();
        }
        //2.计算min
        int min = Integer.MAX_VALUE;
        int sum;
        for(int i=0; i < n; i++){
            sum = traps[i][0] + traps[i][1] - 2;
            if(sum < min)
                min = sum;
        }
        System.out.println(min);
    }
}
