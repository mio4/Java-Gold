package _02_LeetCode_Solution.Array.No338;

public class Solution2 {
    public static int[] countBits(int num) {
        int[] res = new int[num+1];
        if(num == 0){
            return new int[]{0};
        }
        if(num == 1){
            return new int[]{0,1};
        }

        int i = 2, k = 1, p = 2;
        res[1] = 1;
        while(i <= num){
            int middle = (3*p-1)/2;
            if(i <= middle){ //数组前半部分
                res[i] = res[i - p/2];
            }
            else{ //数组后半部分
                res[i] = res[i - p/2] + 1;
            }
            i++;
            //更新k
            if(i == p*2){
                k+=1;
                p = (int)Math.pow(2,k);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        countBits(16);
    }
}
