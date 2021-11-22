package _02_LeetCode_Solution.Array.No49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(int i=0;i < strs.length; i++){
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            if(map.containsKey(key)){
                map.get(key).add(strs[i]);
            }
            else{
                List<String> t = new ArrayList<>();
                t.add(strs[i]);
                map.put(key,t);
            }
        }

        List<List<String>> res = new ArrayList<>();
        for(List<String> value : map.values()){
            res.add(value);
        }
        return res;
    }
}
