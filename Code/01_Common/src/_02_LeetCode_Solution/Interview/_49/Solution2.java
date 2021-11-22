package _02_LeetCode_Solution.Interview._49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    //    先转成字符数组，对每个string排序。
//    然后转成string，用.equal判断是否相同
    private static String sortString(String s) {
        char[] tmp = s.toCharArray();
//        for(int i=0;i<tmp.length - i;i++){
//            for(int j=0; j+1<tmp.length;j++){
//                if(tmp[j] > tmp[j+1]) {
//                    char c = tmp[j];
//                    tmp[j] = tmp[j + 1];
//                    tmp[j + 1] = c;
//                }
//            }
//        }
        Arrays.sort(tmp);
        return String.valueOf(tmp);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        System.out.println(strs.length);
        List<String> chars = new ArrayList<String>();
        List<List<String>> rst = new ArrayList<List<String>>();
        for (int i = 0; i < strs.length; i++) {
            chars.add(sortString(strs[i]));
        }
        for (int i = 0; i < chars.size(); i++) {
            if (chars.get(i) == null) continue;
            List<String> tmp = new ArrayList<String>();
            tmp.add(strs[i]);
            for (int j = i + 1; j < chars.size(); j++) {
                if (chars.get(j) != null && !strs[j].equals(strs[i]) && chars.get(j).equals(chars.get(i))) {
                    tmp.add(strs[j]);
                    chars.set(j, null);
                }
            }

            rst.add(tmp);
        }
        System.out.println(rst.size());
        for (int i = 0; i < rst.size(); i++) {
            if (rst.get(i).size() > 1) {
                for (int j = 0; j < rst.get(i).size(); j++) {
                    System.out.println(rst.get(i).get(j));
                }
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        String[] str = {"compilations", "bewailed", "horology", "lactated", "blindsided", "swoop", "foretasted", "ware", "abuts", "stepchild", "arriving", "magnet", "vacating", "relegates", "scale", "melodically", "proprietresses", "parties", "ambiguities", "bootblacks", "shipbuilders", "umping", "belittling", "lef"};
    }
}