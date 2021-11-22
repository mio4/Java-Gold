package Interview2020.DJI._2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            Map<String,String> map = new HashMap<>();
            for(int i=0; i < N; i++){
                String s1 = sc.next();
                String s2 = sc.next();
                map.put(s1,s2);
            }
            for(int i=0; i < M; i++){
                String key = sc.next();
                String value = map.get(key);
                System.out.println(value);
            }
        }
    }
}
