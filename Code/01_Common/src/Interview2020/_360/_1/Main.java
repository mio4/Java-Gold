package Interview2020._360._1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] map = new int[N][M];
        int total = 0;
        for(int i=0; i < N; i++){
            for(int j=0; j < M; j++){
                int cur = sc.nextInt();
                total += (6*cur);
                map[i][j] = cur;
            }
        }

        boolean isDone = false;

        while(!isDone){
            isDone = true;
            //1. 计算平面内损失的面积
            for(int i=0; i < N; i++){
                for(int j=0; j < M; j++){
                    if(map[i][j] >= 1){
                        if(i-1>=0 && map[i-1][j] >= 1) total--;
                        if(i+1<N && map[i+1][j] >= 1)  total--;
                        if(j-1>=0 && map[i][j-1] >= 1) total--;
                        if(j+1<M && map[i][j+1] >= 1)  total--;
                    }
                }
            }
            //2. 更新平面
            for(int i=0; i < N; i++){
                for(int j=0; j < M; j++){
                    if(map[i][j] >= 1){
                        if(map[i][j] > 1)
                            total-=2;
                        map[i][j] = map[i][j]-1;
                        isDone = false;
                    }
                }
            }

        }

        System.out.println(total);
    }
}
