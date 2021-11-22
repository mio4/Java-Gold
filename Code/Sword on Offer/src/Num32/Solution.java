package Num32;

import java.util.ArrayList;

class TreeNode {
	 int val = 0;
	 TreeNode left = null;
	 TreeNode right = null;

	 public TreeNode(int val) {
	 this.val = val;

	 }
 }
public class Solution {
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<TreeNode> collec = new ArrayList<TreeNode>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(root != null){
			collec.add(root);
		}
		while(collec.size() != 0){
			TreeNode tmp = collec.get(0);
			if(tmp.left != null)
				collec.add(tmp.left);
			if(tmp.right != null)
				collec.add(tmp.right);
			collec.remove(0);
			result.add(tmp.val);
		}
		return result;
	}
	public static void main(String[] args){
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		System.out.println(a.get(0));
		a.remove(0);
		System.out.println(a.get(0));
		a.remove(0);
		System.out.println(a.get(0));
		a.remove(0);
		System.out.println(a.get(0));
	}
}
