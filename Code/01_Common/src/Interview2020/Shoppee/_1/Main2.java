package Interview2020.Shoppee._1;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        //1. 获取输入
        Scanner sc = new Scanner(System.in);
        int headCount = sc.nextInt();
        int[][] map = new int[headCount][61];
        for(int i=0; i < headCount; i++){
            int scoreCount = sc.nextInt();
            for(int j=0; j < scoreCount; j++){
                int score = sc.nextInt();
                map[i][score] = 1;
            }
        }
        int matchCount = sc.nextInt();
        int[] match = new int[matchCount];
        for(int i=0; i < matchCount; i++){
            match[i] = sc.nextInt();
        }

        //2. 处理数据
        int[] scores = new int[headCount];
        for(int i=0; i < headCount; i++){
            int counter = 0;
            for(int j=0; j < matchCount; j++){
                if(map[i][match[j]] == 1)
                    counter++;
            }
            scores[i] = counter;
        }

        //3. 打印结果
        int result = 0;
        for(int i=1; i < headCount; i++){
            if(scores[i] > scores[result])
                result = i;
        }
        System.out.println(result+1);
    }
}
