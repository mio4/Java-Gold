package Num20_2;

public class Solution {
	public static boolean isNumeric(char[] str) {
		boolean havesignal=false; //是否出现了+-号
		boolean haveE=false; //是否出现E/e
		boolean haveRadix=false; //是否出现小数点
		if(str == null || str.length == 0) //边界条件
			return false;

		for(int i=0; i < str.length; i++){
			if(str[i] == 'E' || str[i] == 'e'){
				if(haveE) //不能有多个E/e
					return false;
				if(i == str.length-1) //E/e不能是最后一个字符
					return false;
				haveE = true;
			} else if(str[i] == '+' || str[i] == '-'){
				if(havesignal  && (str[i-1] != 'E' && str[i-1] != 'e')) //如果已经出现了符号但是这个+-号不在E/e之后
					return false;
				if(!havesignal && i > 0 && str[i-1] != 'E' && str[i-1] != 'e')
					return false;
				havesignal = true;
			} else if(str[i] == '.'){
				if(haveRadix) //不能有多个小数点
					return false;
				if(haveE) //小数点不能在E/e之后
					return false;
				haveRadix = true;
			} else if(!(str[i] >= '0' && str[i] <= '9')){
				return false;
			}
		}

		return true;
	}


	public static void main(String[] args){
		String s1 = "+100";
		String s2 = "5e2";
		String s3 = "-123";
		String s4 = "3.14159";
		String s5 = "-1E-16";
		String s6 = "12e";
		String s7 = "1a3.14";
		String s8 = "1.2.3";
		String s9 = "+-5";
		String s10 = "12e+5.4";
		System.out.println("s1 " + isNumeric(s1.toCharArray())); //true
		System.out.println("s2 " + isNumeric(s2.toCharArray())); //true
		System.out.println("s3 " + isNumeric(s3.toCharArray())); //true
		System.out.println("s4 " + isNumeric(s4.toCharArray())); //true
		System.out.println("s5 " + isNumeric(s5.toCharArray())); //true
		System.out.println("s6 " + isNumeric(s6.toCharArray())); //false
		System.out.println("s7 " + isNumeric(s7.toCharArray())); //false
		System.out.println("s8 " + isNumeric(s8.toCharArray())); //false
		System.out.println("s9 " + isNumeric(s9.toCharArray())); //false
		System.out.println("s10 " + isNumeric(s10.toCharArray())); //true
		char[] cs = {'a','b'};
		System.out.println(String.valueOf(cs));
	}
}
