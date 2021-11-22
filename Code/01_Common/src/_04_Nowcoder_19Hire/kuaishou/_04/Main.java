package _04_Nowcoder_19Hire.kuaishou._04;

import java.util.Scanner;

/**
 * 最长回文子串的个数
 */
public class Main{
    private static int res = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        for(int i=0; i < s.length(); i++){
            Helper(s,i,i);
            Helper(s,i,i+1);
        }

        System.out.println(res);
    }

    private static void Helper(String s,int i, int j){
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            res++;
            i--;
            j++;
        }
    }

}
