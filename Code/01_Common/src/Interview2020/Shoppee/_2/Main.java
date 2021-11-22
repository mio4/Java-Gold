package Interview2020.Shoppee._2;

import java.util.Scanner;

/**
 * 12345
 * -12345
 * 假设16位，从-65535~65536
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        s = reverse(s);
        Long res = Long.valueOf(s);
        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE){
            System.out.println(0);
        }
        else{
            System.out.println(res);
        }
    }

    private static String reverse(String s){
        int left = 0;
        if(s.charAt(0) == '-'){
            left = 1;
        }
        int right = s.length()-1;

        char[] cs = s.toCharArray();
        while(left < right){
            char t = cs[left];
            cs[left] = cs[right];
            cs[right] = t;

            left++;
            right--;
        }

        return new String(cs);
    }
}
