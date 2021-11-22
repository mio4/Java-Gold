package Interview2017.wangyi.No5;

/**
 * 	https://www.nowcoder.com/practice/ca7b8af83e2f4ec1af2f23d6733223b5?tpId=85&tqId=29845&tPage=1&rp=1&ru=/ta/2017test&qru=/ta/2017test/question-ranking
 */
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int len = s.length();
        //1.是否存在非大写字母
        for(int i=0; i < len; i++){
            if(!(s.charAt(i) >= 'A' && s.charAt(i)<= 'Z')){
                System.out.println("Dislikes");
                return;
            }
        }
        //2.是否存在连续字母
        for(int i=0; i < len; i++){
            for(int j=i; j < len-1;j++){
                if(s.charAt(j) == s.charAt(j+1)){
                    System.out.println("Dislikes");
                    return;
                }
            }
        }
        //3.是否存在子序列xyxy
        for(int a = 0; a < len; a++){
            for(int b = a+1; b < len; b++){
                for(int c = b+1; c < len; c++){
                    for(int d = c+1; d < len; d++){
                        if(s.charAt(a)==s.charAt(c) && s.charAt(b)==s.charAt(d)){
                            System.out.println("Dislikes");
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("Likes");
    }
}
