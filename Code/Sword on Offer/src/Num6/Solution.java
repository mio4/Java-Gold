package Num6;

import java.util.Arrays;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
public class Solution {
	public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		if((pre.length <= 0 && in.length <= 0) || pre.length != in.length)
			return null;
		//首先找到根节点
		TreeNode root = new TreeNode(pre[0]);
		//然后找到左右子树
		int middle = 0;
		for(int i=0; i < pre.length; i++){
			if(in[i] == pre[0])
				middle = i;
		}
		//数组边界条件：大小为零
		int[] new_pre_left = new int[middle];
		int[] new_pre_right = new int[in.length - middle - 1];
		int[] new_in_left = new int[middle];
		int[] new_in_right = new int[in.length - middle - 1];

		for(int i=0; i < middle; i++){
			new_pre_left[i] = pre[i+1];
			new_in_left[i] = in[i];
		}
		for(int i=0; i < in.length - middle - 1; i++){
			new_pre_right[i] = pre[i+middle+1];
			new_in_right[i] = in[i+middle+1];
		}
		//根据左右子树递归生成新的树
		root.left = reConstructBinaryTree(new_pre_left, new_in_left);
		root.right = reConstructBinaryTree(new_pre_right, new_in_right);

		root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,middle+1),Arrays.copyOfRange(in,0,middle));
		root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,middle+1,in.length),Arrays.copyOfRange(in,middle+1,in.length));


		return root;
	}

	public static void main(String[] args){
		int pre[] = {1, 2, 4, 7, 3, 5, 6, 8};
		int in[] = {4, 7, 2, 1, 5, 3, 8, 6};
		TreeNode root = reConstructBinaryTree(pre,in);
		System.out.println("Done");

		int t[] = Arrays.copyOfRange(pre,0,8);
		for(int i=0; i < t.length; i++)
			System.out.println(t[i]);
	}
}
