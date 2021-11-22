package _01_Algorithm;

/**
 * 问题背景：对于一个字符串S，要寻找字符串P在S中的位置
 *
 */
public class KMP {

    //暴力匹配算法
    public static int BruteForce(String s,String p){
        int i=0,j=0;
        while(i < s.length() && j < p.length()){
            if(s.charAt(i) == p.charAt(j)){
                i++;
                j++;
            }
            else{
                i = (i-j+1);
                j = 0;
            }
        }
        return (i-p.length()+1);
    }

    //[看毛片]算法
    public static void KMP(String s,String p){

    }

    public static void main(String[] args) {
        String s = "BBC ABCDAB ABCDABCDABDE";
        String p = "ABCDABD";
        System.out.println(BruteForce(s,p));
    }
}
