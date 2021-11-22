package Interview2020.WangYi._1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = scanner.nextInt();
        int[] scores = new int[cnt];
        for(int i=0; i < cnt; i++){
            scores[i] = scanner.nextInt();
        }

        int queryCnt = scanner.nextInt();
        int[] queryScore = new int[queryCnt];
        for(int i=0; i < queryCnt; i++){
            queryScore[i] = scores[scanner.nextInt()-1];
        }

        Arrays.sort(scores);
        for(int i=0; i < queryCnt; i++){
            double pos  = ((double)Arrays.binarySearch(scores,queryScore[i])/cnt) * 100;
            System.out.println(String.format("%.6f",pos));
        }

    }
}
