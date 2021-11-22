package _02_LeetCode_Solution.Array.No950;

import java.util.Arrays;

/**
 * 1. 将现实中显示的关系映射到变量名上
 * 2. Control your code 对于循环的执行以及代码的设计需要自身非常清晰
 */
class Solution {
    public static int[] deckRevealedIncreasing(int[] deck) {
        int i,k,zero_cnt;
        int len = deck.length;
        int result[] = new int[len];
        Arrays.sort(deck);
        for(i=0,k=0,zero_cnt = 2; i < len-1;){
            result[k] = deck[i];
            zero_cnt = 0;
            i++;

            while(zero_cnt < 2){
                k = (k+1) % len;
                if(result[k] == 0)
                    zero_cnt++;
            }
        }
        for(i=0; i < len;i++){
            if(result[i] == 0)
                result[i] = deck[len-1];
        }
        return result;
    }

    public static void main(String[] args){
        int deck[] = {17,13,11,2,3,5,7};
        System.out.println(Arrays.toString(deckRevealedIncreasing(deck)));
        int deck2[] = {1,2};
        System.out.println(Arrays.toString(deckRevealedIncreasing(deck2)));
    }
}
