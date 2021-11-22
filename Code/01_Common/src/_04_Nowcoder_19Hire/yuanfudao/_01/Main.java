package _04_Nowcoder_19Hire.yuanfudao._01;

/**
 * https://www.nowcoder.com/practice/a776dfef53914c23a4271fc5fe608369?tpId=98&tqId=32888&tPage=4&rp=4&ru=/ta/2019test&qru=/ta/2019test/question-ranking
 * TODO WA 不知道为啥
 */
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        //1. 读入数据
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int bus = sc.nextInt();
        int[] members = new int[num];
        for(int i=0; i < num; i++){
            members[i] = sc.nextInt();
        }

        //2. 数据处理
        int split_cnt = num/bus + 1;
        int[] sp = new int[split_cnt];
        for(int i=0,j=0; i < num;i+=3,j++){
            sp[j] = i;
        }
        //输出
        int end = members[num-1];
        for(int i=split_cnt-1; i >= 0;i--){
            for(int j=sp[i]; j <= end; j++){
                System.out.print(members[j] + " ");
            }
            end = sp[i]-1;
        }
    }
}
