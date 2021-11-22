package Interview2020.WangYi._4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //输出30%
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int queryCnt = sc.nextInt();
        int[] nums = new int[cnt];
        for(int i=0; i < cnt; i++){
            nums[i] = sc.nextInt();
        }

        int[] query = new int[queryCnt];
        for(int i=0; i < queryCnt; i++){
            query[i] = sc.nextInt();
        }

        for(int i=0; i < queryCnt; i++){
            int res = 0;
            for(int j=0; j < cnt; j++){
                if (nums[j] >= query[i]){
                    res++;
                    nums[j]--;
                }
            }
            System.out.println(res);
        }
    }
}
