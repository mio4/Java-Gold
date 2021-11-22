package _02_LeetCode_Solution.Interview._394;

public class Solution {
    private static int index = 0;
    public static String decodeString(String s) {
        char[] cs = s.toCharArray();
        return helper(cs,cs.length);
    }

    private static String helper(char[] cs,int len){
        String cur = "";
        while(index < len) {
            if (isNum(cs[index])) {
                String num = "";
                while (isNum(cs[index])) {
                    num += cs[index];
                    index++;
                }

                if (cs[index] == '[') {
                    index++;
                    String next = helper(cs,len);
                    for (int i = 0; i < Integer.valueOf(num); i++) {
                        cur += next;
                    }
                }
            } else if (cs[index] == ']') {
                index++;
                return cur;
            } else {
                cur += cs[index];
                index++;
            }
        }
        return cur;
    }

    private static boolean isNum(char c){
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]")); //"accaccacc"
        System.out.println(decodeString("3[a]2[bc]")); //"aaabcbc"
    }
}
