package _02_LeetCode_Solution.DFS.No93;

import java.util.ArrayList;
import java.util.List;

/**
 * 对递归的理解只能在一遍遍断点之中慢慢体会了
 * 这道题其实和那个求[1,3,4,6,8]中和为target的题差不多的思想
 */
class Solution3 {
    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        if(s == null || s.length() < 3 || s.length() > 12)
            return res;
        dfs(res,s,new String(),4);
        return res;
    }

    public static void dfs(List<String> res,String s,String out,int k){
        if(k == 0){
            if(s.isEmpty())
                res.add(out);
        }
        else{
            for(int i=1; i <=3; i++){
                if(s.length() >= i && isValid(s.substring(0,i))){
                    if(k == 1)
                        dfs(res,s.substring(i),out+s.substring(0,i),k-1);
                    else
                        dfs(res,s.substring(i),out+s.substring(0,i)+".",k-1);
                }
            }
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
    }
}
