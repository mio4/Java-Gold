package _02_LeetCode_Solution.Array.No49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        for(int i=0;i < strs.length; i++){
            String key = sort(strs[i]);
            if(map.containsKey(key)){
                map.get(key).add(strs[i]);
            }
            else{
                List<String> t = new ArrayList<>();
                t.add(strs[i]);
                map.put(key,t);
            }
        }
        for(List<String> value : map.values()){
             res.add(value);
        }
        return res;
    }

    private static String sort(String s){
        char[] c = s.toCharArray();
        int len = s.length();
        for(int i=0; i < len; i++){
            for(int j=0;j < len-1-i;j++){
                if(c[j] > c[j+1]){
                    char t = c[j];
                    c[j] = c[j+1];
                    c[j+1] = t;
                }
            }
        }
        String res = "";
        for(int i=0;i < len; i++){
            res += c[i];
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(sort("eat"));
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strs);
    }
}
