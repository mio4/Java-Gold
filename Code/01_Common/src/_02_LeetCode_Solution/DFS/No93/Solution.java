package _02_LeetCode_Solution.DFS.No93;

import java.util.LinkedList;
import java.util.List;

/**
 * 使用DFS
 */
class Solution {
    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new LinkedList<String>();
        if(s == null || s.length() < 4 || s.length() > 12)
            return res;
        dfs(res,0,new String(),s);
        return res;
    }

    public static void dfs(List<String> res,int start,String prefix,String s){
        if(start == 3 && isValid(s))
            res.add(prefix+s);
        for(int i=0; i < 3 && i < s.length()-1; i++){
            String subString = s.substring(0,i+1);
            if(isValid(subString))
                dfs(res,start+1,prefix+subString+".",s.substring(i+1,s.length()));
        }
    }

    public static boolean isValid(String s){ //检查字符段是否有效
        if(s.charAt(0) == '0')
            return s.length()==1;
        int num = Integer.valueOf(s);
        if(num >= 0 && num <= 255)
            return true;
        else
            return false;
    }

    public static void main(String[] args){
        String s = "25525511135";
        System.out.println(restoreIpAddresses(s));
        String s2 = "010010";
        System.out.println(restoreIpAddresses(s2));
    }

}
