package Num4;

public class Solution {
	public static String replaceSpace(StringBuffer str) {
		StringBuffer after = new StringBuffer();
		int len = str.length();
		for(int i=0; i < len; i++){
			if(str.charAt(i) == ' ') {
				after.append("%20");
			} else {
				after.append(str.charAt(i));
			}
		}
		return after.toString();
	}
	public static void main(String[] args){
		StringBuffer sb = new StringBuffer("We are happy");
		System.out.println(replaceSpace(sb));
	}
}