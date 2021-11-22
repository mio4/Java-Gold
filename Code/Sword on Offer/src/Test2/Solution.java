package Test2;

public class Solution {
	public static String ReverseSentence(String str) {
		char[] chars = str.toCharArray();
		reverse(chars,0,chars.length - 1);
		int blank = -1;
		for(int i = 0;i < chars.length;i++){
			if(chars[i] == ' '){
				int nextBlank = i;
				reverse(chars,blank + 1,nextBlank - 1);
				blank = nextBlank;
			}
		}
		reverse(chars,blank + 1,chars.length - 1);//最后一个单词单独进行反转
		return new String(chars);

	}
	public static void reverse(char[] chars,int low,int high){
		while(low < high){
			char temp = chars[low];
			chars[low] = chars[high];
			chars[high] = temp;
			low++;
			high--;
		}
	}
	public static void main(String[] args){
		String str = "You Me ";
		String s2 ="Wonderful";
		System.out.println(ReverseSentence(str));
		System.out.println(ReverseSentence(s2));

	}
}
