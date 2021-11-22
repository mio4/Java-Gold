import java.util.ArrayList;

public class Solution{
	public static void main(String[] args){
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		add_list(list);
		for(int i=0;i < 2;i++)
			System.out.println(list.get(i));
	}

	public static void add_list(ArrayList<Integer> list){
		list.add(2);
	}
}