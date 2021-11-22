package Num61;

import java.util.Arrays;

public class Solution {
	public boolean isContinuous(int [] numbers) {
		Arrays.sort(numbers);

		//0的个数
		int len = numbers.length;
		int zero_cnt = 0;
		for(int i=0; i < len; i++){
			if(numbers[i] == 0)
				zero_cnt++;
		}
		//如果存在对子，那么一定不是顺子
		for(int i=zero_cnt; i < len-1; i++){
			if(numbers[i] == numbers[i+1])
				return false;
		}
		//统计数之间的差距
		int sum = 0;
		for(int i=zero_cnt; i < len-1; i++){
			if(numbers[i+1] - numbers[i] > 1)
				sum = sum + numbers[i+1] - numbers[i] - 1;
		}
		return (sum <= zero_cnt);
	}
}
