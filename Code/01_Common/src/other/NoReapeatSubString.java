package other;

/**
 * Given a _02_LeetCode_Solution.String, find the length of the longest substring without repeating characters.
 * 给出一个字符串，计算没有重复字符的最长子串的长度。
 * （1）将ASCII码表映射到一个128位的数组中，使用字符作为数组下标的方式很有意思
 * （2）使用max函数作为判断而不是if-else语句
 * （3）将字母是否已经出现的判断转换为（字母出现的下一个位置和subStart当前字符串开始位置的比较）
 * （4）使用小范围例子来验证自己的猜想【test_case】
 * （5）每经过一次数组，记得更新max_len
 */
public class NoReapeatSubString {
    public static int lengthOfLongestSubString(String s){
        int max_len = 0;
        int[] index = new int[128]; //对应ASCII码表中的每个字符
        int subStart = 0;
        for(int i=0; i < s.length(); i++){
            char ch = s.charAt(i);
            subStart = Math.max(index[ch],subStart);
            max_len = Math.max(max_len,i-subStart+1);
            index[ch] = i+1;
        }

        return max_len;
    }
    public static void main(String[] args){
        System.out.println(lengthOfLongestSubString("abcad"));
    }
}
