package _02_LeetCode_Solution.Interview._49;

import java.util.Arrays;

public class bubbleSort {
    private static String sortString(String s) {
        char[] tmp = s.toCharArray();
        for(int i=0;i<tmp.length ;i++){
            for(int j=0; j+1<tmp.length-i;j++){
                if(tmp[j] > tmp[j+1]) {
                    char c = tmp[j];
                    tmp[j] = tmp[j + 1];
                    tmp[j + 1] = c;
                }
            }
        }
        return String.valueOf(tmp);
    }

    public static void main(String[] args) {
        String s = "9845231";
        System.out.println(sortString(s));
    }
}
