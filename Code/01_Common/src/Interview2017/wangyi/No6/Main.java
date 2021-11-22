package Interview2017.wangyi.No6;

/**
 * https://www.nowcoder.com/practice/9d1559511b3849deaa71b576fa7009dc?tpId=85&tqId=29842&tPage=1&rp=1&ru=/ta/2017test&qru=/ta/2017test/question-ranking
 * 好像没有在本地保存代码的必要
 * （1）保存到牛客网
 * （2）通过博客发表...
 */

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String A = in.next();
        String B = in.next();
        int count = 0;
        int lenA = A.length();
        for(int i=0; i <= lenA; i++){
            StringBuffer sb = new StringBuffer();
            sb.append(A.substring(0,i));
            sb.append(B);
            sb.append(A.substring(i,lenA));
            if(isPalindrome(sb.toString()))
                count++;
        }
        System.out.println(count);
    }

    public static boolean isPalindrome(String s){
        for(int i=0,j=s.length()-1; i < j; i++,j--){
            if(s.charAt(i)!=s.charAt(j))
                return false;
        }
        return true;
    }
}
