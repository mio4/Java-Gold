package Num38;



import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

public class Solution2 {
	public static void main(String[] args) {
		//Solution2 p = new Solution2();
		//System.out.println(p.Permutation("abc").toString());

		Solution p = new Solution();
		System.out.println(p.Permutation("abc").toString());

		//String str = null;
		//char[] cs = str.toCharArray();

		/*ArrayList<String> result = new ArrayList<String>();
		result.add("cba");
		result.add("abc");
		result.add("bac");
		Collections.sort(result);
		System.out.println(result.toString());*/
	}

	public ArrayList<String> Permutation(String str) {
		List<String> res = new ArrayList<>();
		if (str != null && str.length() > 0) {
			PermutationHelper(str.toCharArray(), 0, res);
			Collections.sort(res);
		}
		return (ArrayList)res;
	}

	public void PermutationHelper(char[] cs, int i, List<String> list) {
		if (i == cs.length - 1) {
			String val = String.valueOf(cs);
			if (!list.contains(val))
				list.add(val);
		} else {
			for (int j = i; j < cs.length; j++) {
				swap(cs, i, j);
				PermutationHelper(cs, i+1, list);
				swap(cs, i, j);
			}
		}
	}

	public void swap(char[] cs, int i, int j) {
		char temp = cs[i];
		cs[i] = cs[j];
		cs[j] = temp;
	}

}
