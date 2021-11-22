package Interview2017.wangyi.No3;

/**
 * https://www.nowcoder.com/practice/18ecd0ecf5ef4fe9ba3f17f8d00d2d66?tpId=85&tqId=29846&tPage=1&rp=1&ru=/ta/2017test&qru=/ta/2017test/question-ranking
 */
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int steps = 0;
        int pre = 0,next = 1,temp = -1;
        while(next < num){
            temp = pre+next;
            pre = next;
            next = temp;
        }
        steps = ((num - pre) < (next - num)) ? (num-pre) : (next-num);
        System.out.println(steps);
    }
}
