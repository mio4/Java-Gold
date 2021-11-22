package Num55;

class TreeNode {
	 int val = 0;
	 TreeNode left = null;
	 TreeNode right = null;

	 public TreeNode(int val) {
	 this.val = val;

	 }
 }
public class Solution {
	public int TreeDepth(TreeNode root) {
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return 1;
		return Max(TreeDepth(root.left),TreeDepth(root.right)) + 1;
	}
	public int Max(int a, int b){
		if(a > b)
			return a;
		return b;
	}
}
