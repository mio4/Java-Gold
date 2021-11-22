package _04_Nowcoder_19Hire.yuanfudao._02;

/**
 * https://www.nowcoder.com/practice/1b1f87ef6e7d40529d82c96aef79e8a4?tpId=98&tqId=32889&tPage=4&rp=4&ru=/ta/2019test&qru=/ta/2019test/question-ranking
 * FIXME 80% AC
 */
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        //1. 获取输入
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        String s = sc.next();
        char[] in = new char[cnt];
        for(int i=0; i < cnt;i++){
            in[i] =  s.charAt(i);
        }

        //2. 处理
        int k = cnt/3;
        int in_cnt = 0;
        //2.1 输入V
        int len = 2*k+1;
        for(int i=0,left=0,right=2*k; i < k; i++,left++,right--){
            String t = "";
            for(int i1=0; i1 < left; i1++){
                t+=" ";
            }
            t+=in[in_cnt++];
            for(int i2=left+1; i2 < right;i2++){
                t+=" ";
            }
            t+=in[in_cnt++];
            System.out.println(t);
        }

        //2.2 输出|
        for(int i=0; i < k+1;i++){
            String t = "";
            for(int i1=0;i1 < k;i1++){
                t += " ";
            }
            t+=in[in_cnt++];
            System.out.println(t);
        }

    }
}
