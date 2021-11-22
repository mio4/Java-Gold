package Num59;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution2 {
	public static ArrayList<Integer> maxInWindows(int [] num, int size)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(num == null ||size <= 0 || size > num.length)
			return result;

		LinkedList<Integer> indexQueue = new LinkedList<Integer>(); //下标队列

		for(int i=0; i < size; i++){
			if(!indexQueue.isEmpty() && num[i] > num[indexQueue.getLast()])
				indexQueue.removeLast();
			indexQueue.addLast(i);
		}
		result.add(num[indexQueue.getFirst()]); //第一个窗口开放之后，队首元素就是最大值

		for(int i=size; i < num.length; i++){
			while(!indexQueue.isEmpty() && num[i] > num[indexQueue.getLast()])
				indexQueue.removeLast();
			indexQueue.addLast(i);
			if(i - indexQueue.getFirst() >= size)
				indexQueue.removeFirst();
			result.add(num[indexQueue.getFirst()]);
		}

		return result;
	}

	public static void main(String[] args){
		int[] a = {2,3,4,2,6,2,5};
		maxInWindows(a,3);
	}
}
