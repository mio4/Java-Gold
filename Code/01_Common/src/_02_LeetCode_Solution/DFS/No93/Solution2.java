package _02_LeetCode_Solution.DFS.No93;

import java.util.LinkedList;
import java.util.List;

/**
 * 因为已经是固定四个段，所以可以直接使用暴力解法
 * 边界条件
 * （1）s.length() < 3 || s.length() > 12
 *  IP地址定义：
 *  （1）有四段，每一段的范围是0-255
 *  （2）每一段不能存在前导零
 */
class Solution2 {
    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new LinkedList<String>();
        if(s == null || s.length() < 3 || s.length() > 12)
            return res;
        int len = s.length();
        for(int a=1;a < len; a++){
            for(int b=a+1; b < len; b++){
                for(int c=b+1; c < len; c++){
                        String s1 = s.substring(0,a);
                        String s2 = s.substring(a,b);
                        String s3 = s.substring(b,c);
                        String s4 = s.substring(c,len);
                        if(islegal(s1) && islegal(s2)&& islegal(s3) && islegal(s4))
                            if(s1.length()+s2.length()+s3.length()+s4.length() == s.length())
                                res.add(s1+"."+s2+"."+s3+"."+s4);
                }
            }
        }
        return res;
    }

    public static boolean islegal(String s){
        if(s.length() > 3)
            return false;
        if(s.charAt(0) == '0' && s.length() > 1)
            return false;
        int num = Integer.valueOf(s);
        if(num >= 0 && num <= 255)
            return true;
        return false;
    }

    public static void main(String[] args){
        String s = "25525511135";
        System.out.println(restoreIpAddresses(s));
        String s2 = "010010";
        System.out.println(restoreIpAddresses(s2));
    }
}
