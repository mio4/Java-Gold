package _02_LeetCode_Solution.String.No9;

/**
 * 将数字的首位和最后一位提取出来，判断之后转换数字
 * 2332 -> 33 -> 0
 */
class Solution2 {
    public static boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        if(x >= 0 && x < 10)
            return true;
        int times = 1;
        while(x / times >= 10) times*=10;
        while(x > 0){
            int high = x/times;
            int low = x%10;
            if(high != low)
                return false;
            x %= times;
            x /= 10;
            times /= 100;
        }
        return true;
    }

    public static void main(String[] args){
        isPalindrome(313);
    }
}
