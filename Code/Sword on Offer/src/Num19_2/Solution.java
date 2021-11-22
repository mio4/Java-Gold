package Num19_2;

import java.util.Arrays;

public class Solution {
	public static boolean match(char[] str, char[] pattern)
	{
		if(str == null || pattern == null) //对于边界进行处理
			return false;
		return MatchCore(str,pattern);
	}

	public static boolean MatchCore(char[] str, char[] pattern){
		if(str.length == 0 && pattern.length == 0) //都匹配到字符串末端
			return true;
		if(str.length != 0 && pattern.length == 0) //模式已经用光，字符串还有剩余的情况
			return false;

		if(pattern.length > 1 && pattern[1] == '*'){ //对于模式第二个字符是*
			if(str.length > 0 && (pattern[0] == str[0] || pattern[0] == '.' && str.length != 0))
				return MatchCore(Arrays.copyOfRange(str,1,str.length),Arrays.copyOfRange(pattern,2,pattern.length))
				|| MatchCore(Arrays.copyOfRange(str,1,str.length),pattern)
				|| MatchCore(str,Arrays.copyOfRange(pattern,2,pattern.length));
			else
				return MatchCore(str,Arrays.copyOfRange(pattern,2,pattern.length));
		}

		if(str.length!=0 && (pattern[0] == str[0] || pattern[0] == '.' && str.length != 0)) //对于一般的匹配情况
			return MatchCore(Arrays.copyOfRange(str,1,str.length),Arrays.copyOfRange(pattern,1,pattern.length));

		return false;
	}

	public static void main(String[] args){
		char[] str = {'a','a','a'};
		char[] pattern = {'a','.','a'};
		System.out.println(match(str,pattern));

		char[] str2 = {'a','a','a'};
		char[] pattern2 = {'a','b','*','a','c','*','a'};
		System.out.println(match(str2,pattern2));

		char[] str3 = {'a','a','a'};
		char[] pattern3 = {'a','a','.','a'};
		System.out.println(match(str3,pattern3));

		char[] str4 = {};
		char[] pattern4 = {'.','*'};
		System.out.println(match(str4,pattern4));
	}
}
