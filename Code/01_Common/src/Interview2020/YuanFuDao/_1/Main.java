package Interview2020.YuanFuDao._1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        String[] words = new String[cnt];
        for(int i=0; i < cnt; i++){
            words[i] = sc.next();
        }

        for(int i=0; i < cnt; i++){
            String s = words[i];
            StringBuilder sb = new StringBuilder();
            int j=0;
            while(j < s.length()){
                String t = "";
                int times = 0;
                if(s.charAt(j) == '('){ //遇到括号
                    j++;
                    while(s.charAt(j) != ')'){
                        t+=s.charAt(j);
                        j++;
                    }
                    String num = "";
                    j++;
                    while(j < s.length() && isNum(s.charAt(j))){
                        num+=s.charAt(j);
                        j++;
                    }
                    times = Integer.valueOf(num);
                    //倍数处理
                    for(int k=0; k < times; k++){
                        sb.append(t);
                    }
                }
                else if(isChar(s.charAt(j))){ //遇到字母
                    if(j == s.length()-1){ //如果是最后一个字母
                        sb.append(s.charAt(j));
                        j++;
                    }
                    else{ //如果不是最后一个字母
                        t+=s.charAt(j);
                        if(!isNum(s.charAt(j+1))){ //如果下个不是数字
                            sb.append(t);
                            j++;
                        }
                        else{ //如果下个是数字
                            String num = "";
                            j++;
                            while(j < s.length() && isNum(s.charAt(j))){
                                num+=s.charAt(j);
                                j++;
                            }
                            times = Integer.valueOf(num);
                            //倍数处理
                            for(int k=0; k < times; k++){
                                sb.append(t);
                            }
                        }
                    }
                }

            }

            System.out.println(sb.toString());
        }
    }

    private static boolean isNum(char c){
        return c >= '0' && c <= '9';
    }

    private static boolean isChar(char c){
        return c >= 'A' && c <= 'Z';
    }
}
