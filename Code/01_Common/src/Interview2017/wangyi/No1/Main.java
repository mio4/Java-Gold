package Interview2017.wangyi.No1;

/**
 * https://www.nowcoder.com/practice/657d09e2b3704574814089ba8566d98d?tpId=85&tqId=29849&tPage=1&rp=1&ru=/ta/2017test&qru=/ta/2017test/question-ranking
 */

import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int cnt = in.nextInt();
        int[] input = new int[cnt];
        for(int i=0; i < cnt; i++){ //获取输入
            input[i] = in.nextInt();
        }
        for(int i=0; i < cnt; i++){ //处理逻辑
            int n = input[i];
            //Queue<Integer> queue = new _02_LeetCode_Solution.LinkedList<Integer>();
            Deque<Integer> queue = new ArrayDeque<Integer>();
            while(n > 0){
                queue.addFirst(n);
                int tail = queue.removeLast();
                queue.addFirst(tail);
                n--;
            }
            int size = queue.size();
            for(int j=0; j < size; j++){
                if(j != size-1)
                    System.out.print(queue.getFirst() + " ");
                else
                    System.out.println(queue.getFirst());
                queue.removeFirst();
            }
        }
    }
}
