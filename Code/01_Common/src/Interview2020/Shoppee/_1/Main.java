package Interview2020.Shoppee._1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //1. 首先是获取输入
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] res = new int[num][];
        for(int i=0; i < num; i++){
            int totalScore = sc.nextInt();
            int[] score = new int[totalScore];
            for(int j=0; j < totalScore; j++){
                score[j] = sc.nextInt();
            }
            res[i] = score;
        }
        int totalNeed = sc.nextInt();
        int[] needler = new int[totalNeed];
        for(int i=0; i < totalNeed; i++){
            needler[i] = sc.nextInt();
        }

        //2. 然后是获取total指标
        int[] scores = new int[num];
        for(int i=0; i < num; i++){
            scores[i] = helper(res[i],needler);
        }

        //3. 输出结果
        int r = 0;
        for(int i=1; i < num; i++){
            if(scores[i] > scores[r]){
                r = i;
            }
        }
        System.out.println(r+1);
    }

    private static int helper(int[] origin,int[] needler){ //比较时间复杂度太大
        int res = 0;
        for(int i=0; i < needler.length; i++){
            for(int j=0; j < origin.length; j++){
                if(needler[i] == origin[j]){
                    res++;
                    break;
                }
            }
        }
        return res;
    }


}
