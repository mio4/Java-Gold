package Interview2020.JD._2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][n];
        for(int i=0; i < m; i++){
            int t1 = sc.nextInt();
            int t2 = sc.nextInt();
            if(t1 <= n)
                map[t1-1][t2-n-1] = 1;
            else
                map[t2-1][t1-n-1] = 1;
        }

        int res = 0;
        List<Integer> persons = new ArrayList<>();
        while(!isDone(map)){
            int t = findMax(map);
            if(t < map.length){ //横向清理
                for(int i=0; i < map.length;i++)
                    map[t][i] = 0;
            }
            else{ //纵向清理
                for(int i=0; i < map.length;i++)
                    map[i][t-n] = 1;
            }
            res++;
            persons.add(t+1);
        }

        System.out.println(res);
        for(int i=0; i < persons.size(); i++){
            System.out.print(persons.get(i) + " ");
        }
    }

    public static int findMax(int[][] map){
        int max_cnt = 0;
        int max_idx = 0;
        //1. 一行一行遍历
        for(int i=0; i < map.length; i++){
            int cur_cnt = 0;
            for(int j=0; j < map[0].length; j++){
                if(map[i][j] == 1)
                    cur_cnt++;
            }
            if(cur_cnt > max_cnt){
                max_cnt = cur_cnt;
                max_idx = i;
            }
        }
        //2. 一列一列遍历
        for(int i=0; i < map[0].length; i++){
            int cur_cnt = 0;
            for(int j=0; j < map.length; j++){
                if(map[i][j] == 1)
                    cur_cnt++;
            }
            if(cur_cnt > max_cnt){
                max_cnt = cur_cnt;
                max_idx = i+map.length;
            }
        }

        return max_idx;
    }

    public static boolean isDone(int[][] map){
        for(int i=0; i < map.length; i++){
            for(int j=0; j < map[0].length; j++){
                if(map[i][j] == 1)
                    return false;
            }
        }

        return true;
    }
}
