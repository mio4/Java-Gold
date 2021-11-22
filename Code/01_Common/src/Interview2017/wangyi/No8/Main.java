package Interview2017.wangyi.No8;
/**
 * https://www.nowcoder.com/practice/5ee8df898312465a95553d82ad8898c3?tpId=85&tqId=29843&tPage=1&rp=1&ru=/ta/2017test&qru=/ta/2017test/question-ranking
 */

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int x  = in.nextInt();
        in.close();
        int count = 0;
        int mod;
        while(x!=0 && count <= 300000){
            count++;
            x = ((x << 1) + 1) % 1000000007;
        }
        if((count+2)/3 <= 100000)
            System.out.println((count+2)/3);
        else
            System.out.println(-1);
    }
}
