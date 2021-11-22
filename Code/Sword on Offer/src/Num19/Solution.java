package Num19;

class TreeNode {
	 int val = 0;
	 TreeNode left = null;
	 TreeNode right = null;

	 public TreeNode(int val) {
	 this.val = val;

	 }
 }

public class Solution {
	public static void Mirror(TreeNode root) {
		if(root != null) {
			if (root.left != null || root.right != null) { //交换节点
				TreeNode tmpNode = root.left;
				root.left = root.right;
				root.right = tmpNode;
			}
			if (root.left != null)
				Mirror(root.left);
			if (root.right != null)
				Mirror(root.right);
		}
	}

	public static void main(String[] args){
		System.out.println("?");
		TreeNode root = new TreeNode(8);
		TreeNode p1 = new TreeNode(6);
		TreeNode p2 = new TreeNode(10);
		TreeNode p3 = new TreeNode(5);
		TreeNode p4 = new TreeNode(7);
		TreeNode p5 = new TreeNode(9);
		TreeNode p6 = new TreeNode(11);
		root.left = p1;
		root.right = p2;
		p1.left = p3;
		p1.right = p4;
		p2.left = p5;
		p2.right = p6;
		Mirror(root);
		System.out.println(root);
	}
}
