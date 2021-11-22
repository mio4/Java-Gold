package _02_LeetCode_Solution.Interview._49;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(int i=0; i < strs.length; i++){
            String s = strs[i];
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            String sort_s = String.valueOf(cs);
            if(!map.containsKey(sort_s)){
                map.put(sort_s,new ArrayList<>());
            }
            map.get(sort_s).add(s);
        }

        Iterator<Map.Entry<String,List<String>>> iter = map.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<String,List<String>> m = iter.next();
            res.add(m.getValue());
        }

        return res;
    }
}
