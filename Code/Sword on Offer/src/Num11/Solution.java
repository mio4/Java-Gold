package Num11;
//指数是否是负数，base是否是0
public class Solution {
	public double Power(double base, int exponent) {
		//底数是否为零
		if(base == 0 && exponent < 0){
			System.out.println("除零错误");
			return 0;
		}

		double result = 1.0;
		//指数是否是负数
		if(exponent < 0){
			result = PowerWithPositiveExp(base,-exponent);
			result = 1 / result;
		} else{
			result = PowerWithPositiveExp(base,exponent);
		}

		return result;
	}

	public double PowerWithPositiveExp(double base, int exponent){
		double result = 1.0;
		for(int i=0; i < exponent; i++)
			result *= base;
		return result;
	}

	public double PowerWithPositiveExp2(double base, int exponent){
		if(exponent == 0)
			return 1;
		if(exponent == 1)
			return base;
		double result = PowerWithPositiveExp2(base,exponent/2);
		result *= result;
		if((exponent & 0x1) == 1)
			result *= base;
		return result;
	}

	public boolean equal(double x, double y){ //如果x和y差距足够小，可以默认为相等
		return ((x-y < 0.0000001));
	}
}
