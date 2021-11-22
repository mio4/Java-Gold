package _04_Nowcoder_19Hire.kuaishou._01;

/**
 * https://www.nowcoder.com/practice/0425aa0df74646209d3f56f627298ab2?tpId=98&tqId=32845&tPage=2&rp=2&ru=/ta/2019test&qru=/ta/2019test/question-ranking
 */
import java.util.Scanner;
import java.util.Arrays;
public class Main{
    public static void main(String[] args){
        //读取数据
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        String[] input = new String[cnt];
        for(int i=0; i < cnt; i++){
            input[i] = sc.next();
        }
        //切割字符串
        String[] res_s = new String[cnt];
        for(int i=0; i < cnt;i++){
            int len = input[i].length();
            res_s[i] = input[i].substring(len-6,len);
        }
        //排序
        Arrays.sort(res_s);
        //输出
        for(int i=0; i < cnt;i++){
            System.out.println(res_s[i]);
        }
    }
}
