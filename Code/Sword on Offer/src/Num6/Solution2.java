package Num6;

import java.util.Arrays;

public class Solution2 {
	public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
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

		root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,middle+1),Arrays.copyOfRange(in,1,middle+1));
		root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,middle+1,in.length+1),Arrays.copyOfRange(in,middle+1,in.length+1));

		return root;
	}
}
