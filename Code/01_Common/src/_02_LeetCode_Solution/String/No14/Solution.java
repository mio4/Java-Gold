package _02_LeetCode_Solution.String.No14;

/**
 * 特殊输入： {""} {"a"}
 * 处理边界情况的能力
 */
class Solution {
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        if(strs == null || strs.length == 0 || "".equals(strs[0]))
            return sb.toString();
        int i,index = 0;
        while(true){
            if(index >= strs[0].length())
                return sb.toString();
            char ch = strs[0].charAt(index);
            for(i=1; i < strs.length; i++){
                if(index >= strs[i].length() || strs[i].charAt(index) != ch)
                    return sb.toString();
            }
            sb.append(String.valueOf(ch));
            index++;
        }
    }

    public static void main(String[] args){
        String[] strs = new String[2];
        strs[0] = "aa";
        strs[1] = "a";
        longestCommonPrefix(strs);
    }
}
