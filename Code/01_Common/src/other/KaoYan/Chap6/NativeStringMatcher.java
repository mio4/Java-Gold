package other.KaoYan.Chap6;

/**
 * 暴力匹配算法
 * 时间复杂度为O((n-m+1)*m)
 */
public class NativeStringMatcher {
    public static int match(String ss, String ps){
        int ss_len = ss.length();
        int ps_len = ps.length();
        int i = 0;
        int j = 0;
        while(i < ss_len && j < ps_len){
            if(ss.charAt(i) == ps.charAt(j)){
                i++;
                j++;
            } else{
                i = i - j + 1;
                j = 0;
            }
        }
        if(j == ps_len){
            return (i - j);
        }
        return -1;
    }

    public static void main(String[] args){
        System.out.println(match("ababcabcacbab","abcac"));
    }
}
