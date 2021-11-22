package Interview2020.YuanFuDao._2;

import java.util.Arrays;

public class Test { //FAIL
    public static void main(String[] args) {
        int[][] a = new int[10][10];
        Arrays.fill(a,-1);
        for(int i=0; i < 10; i++){
            for(int j=0; j < 10; j++){
                System.out.println(a[i][j]);
            }
        }
    }
}
