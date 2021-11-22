package _04_Nowcoder_19Hire.kuaishou._02;

/**
 * https://www.nowcoder.com/practice/5bfb74efcd5449e69a480550b1fef431?tpId=98&tqId=32846&tPage=2&rp=2&ru=%2Fta%2F2019test&qru=%2Fta%2F2019test%2Fquestion-ranking
 */
import java.util.Scanner;
/**
 dp[i][j]表示从i开始，j结束的字符串最长回文子序列，求dp[0][s.length()]
 dp[i][i] = 1
 dp[i][j] = dp[i+1][j-1]+2 (s[i] = s[j])
 dp[i][j] = max(dp[i+1][j],dp[i][j-1]) (s[i] != s[j])

 写出迭代方程之后如何使用双重循环对DP数组进行赋值
 (1)j表示子序列起始位置
 (2)(i+1)表示子序列长度，则dp[j][j+i]表示切割字符串：
    [1]首先遍历长度为1~s.length()
    [2]其次第二层循环的终止条件是j+i < s.length
 **/
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int[][] dp = new int[s.length()+1][s.length()+1];
        //1. 初始化数组
        for(int i=0; i < s.length()+1; i++){
            dp[i][i] = 1;
        }

        //2. 动态规划迭代
        for(int i=1; i <= s.length(); i++){ //(i+1)表示子序列长度
            for(int j=0; j + i < s.length(); j++){ //j表示子序列起始位置
                if(s.charAt(j) == s.charAt(j+i)){
                    dp[j][j+i] = dp[j+1][j+i-1]+2;
                }
                else{
                    dp[j][j+i] = Math.max(dp[j+1][j+i],dp[j][j+i-1]);
                }
            }
        }

        System.out.println(dp[0][s.length()-1]);
    }

}