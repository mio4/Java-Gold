package Num58;

public class Solution {
	public static String ReverseSentence(String str) {
		if(str.equals(" "))
			return str;
		if(str == null || str == "") //如果是空字符串
			return str;
		int len = str.length();
		char[] chars = str.toCharArray();
		if(checkIfOneWord(chars))
			return str;
		ReverseWord(chars,0,len-1);
		int i = 0;
		int before_blank = 0;
		int next_blank = 0;
		while(i < len){
			if(chars[i] == ' '){
				next_blank = i;
				ReverseWord(chars,before_blank,next_blank-1);
				i++;
				before_blank = i;
			} else{
				i++;
			}

		}
		String result = new String(chars);
		return result;
	}

	public static void ReverseWord(char[] chars, int left, int right){
		while(left < right){
			char tmp = chars[left];
			chars[left] = chars[right];
			chars[right] = tmp;
			left++;
			right--;
		}
	}

	public static boolean checkIfOneWord(char[] chars){
		for(int i=0; i < chars.length; i++){
			if(chars[i] == ' ')
				return false;
		}
		return true;
	}

	public static void main(String[] args){
		String str = "I am a student.";
		String s2 ="Wonderful";
		System.out.println(ReverseSentence(" "));
		System.out.println(ReverseSentence(str));
		System.out.println(ReverseSentence(s2));
	}
}
