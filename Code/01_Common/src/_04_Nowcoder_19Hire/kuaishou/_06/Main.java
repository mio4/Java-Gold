package _04_Nowcoder_19Hire.kuaishou._06;

/**
 * https://www.nowcoder.com/practice/967133d6656440ba951870eaf17861de?tpId=98&tqId=32858&tPage=2&rp=2&ru=/ta/2019test&qru=/ta/2019test/question-ranking
 *
 * 简单的数学推断题
 */
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = Integer.valueOf(sc.next());
        int[] nums = new int[num+1];
        int cur_num = 1;
        int cur_cnt = 0;
        for(int i=1; i < num+1;i ++){
            nums[i] = cur_num;
            cur_cnt++;
            if(cur_cnt == cur_num){
                cur_cnt = 0;
                cur_num++;
            }
        }
        System.out.println(nums[num]);
    }
}
