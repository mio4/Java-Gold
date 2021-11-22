package Interview2020.DJI._1;

import java.util.Arrays;
import java.util.Scanner;


public class Main {
    private static int max = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseCnt = sc.nextInt();
        for(int i=0; i < caseCnt; i++){
            //获取输入
            int total = sc.nextInt();
            int time = sc.nextInt();
            int[] scores = new int[total];
            int[] times = new int[total];
            for(int j=0; j < total; j++){
                scores[j] = sc.nextInt();
                times[j] = sc.nextInt();
            }

            //处理获得最大值
            int[] used = new int[total];
            Arrays.fill(used,0);
            recursion(used,scores,times,time,0);
            System.out.println(max);
            max = 0;
        }
    }

    private static void recursion(int[] used,int[] scores,int[] times,int time,int cur_score){
        for(int i=0; i < times.length; i++){
            if(used[i] == 0 && time >= times[i]){ //没有被使用
                int[] new_used = Arrays.copyOf(used,used.length);
                new_used[i] = 1;
                max = Math.max(max,cur_score+scores[i]);
                recursion(new_used,scores,times,time-times[i],cur_score+scores[i]);
            }
        }
    }
}
