package _04_Nowcoder_19Hire.kuaishou._03;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * https://www.nowcoder.com/practice/6a6a0e4d6dfa4d89acd73bdfec79cf28?tpId=98&tqId=32848&tPage=2&rp=2&ru=/ta/2019test&qru=/ta/2019test/question-ranking
 * 'a' + 0 [char类型 + int类型] 默认将结果转换为int类型（字节更多）
 * [1]String.valueOf(char)将char类型转换为String类型
 * [2]'a' + "" 默认将char类型转换为String类型
 */
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int res = 0;
        Set<String> set = new TreeSet<>();
        for(int i=0; i <= s.length(); i++){
            String part1 = s.substring(0,i);
            String part2 = s.substring(i,s.length());
            for(int j=0; j < 26; j++){
                char c = (char)('a' + j);
                String middle = String.valueOf(c);
                String t = part1 + middle + part2;
                if(!set.contains(t)){
                    res++;
                    set.add(t);
                }
            }
        }

        System.out.println(res);
    }
}