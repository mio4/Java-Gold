package other.KaoYan.Chap6;

/**
 * 字符串匹配的经典算法
 * 1. Partial Match Table 部分匹配表
 * TODO DEBUG
 */
public class KMP {

    private static int[] next;

    public static int KMPMatch(String ss, String ps){
        int i = 0;
        int j = 0;
        int ss_len = ss.length();
        int ps_len = ps.length();

        getNext(ps);
        while(i < ss_len && j < ps_len){
            if(ss.charAt(i) == ps.charAt(j) || j == -1){
                i++;
                j++;
            } else{
                j = next[j];
            }
        }
        if(j == ps_len)
            return (i - j);
        else
            return -1;

    }

    public static void getNext(String ps){
        next = new int[ps.length()];
        next[0] = -1;
        int i = 0;
        int j = -1;
        while(i < ps.length()){
            if(j == -1 || ps.charAt(i) == ps.charAt(j)){
                i++;
                j++;
                next[i] = j;
            } else{
                j = next[j];
            }
        }
    }

    public static void main(String[] args){
        System.out.println(KMPMatch("ababcabcacbab","ababca"));
    }
}
