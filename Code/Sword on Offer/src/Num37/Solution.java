package Num37;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Solution {
	public static int cnt = -1;
	public static String Serialize(TreeNode root) {
		StringBuffer sb = new StringBuffer();
		if(root == null){
			sb.append("$,");
			return sb.toString();
		}
		sb.append(root.val + ",");
		sb.append(Serialize(root.left));
		sb.append(Serialize(root.right));
		return sb.toString();
	}
	public static TreeNode Deserialize(String str) {
		cnt++;
		String[] strs = str.split(",");
		TreeNode node = null;
		if(!strs[cnt].equals("$") ) {
			node = new TreeNode(Integer.valueOf(strs[cnt]));
			node.left = Deserialize(str);
			node.right = Deserialize(str);
		}
		return node;
	}

	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		TreeNode p1 = new TreeNode(2);
		TreeNode p2 = new TreeNode(3);
		root.left = p1;
		root.right = p2;
		String str = Serialize(root);
		Deserialize(str);
	}
}
