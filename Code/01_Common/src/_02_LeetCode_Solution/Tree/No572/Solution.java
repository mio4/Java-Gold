package _02_LeetCode_Solution.Tree.No572;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        this.val = x;
    }
}

/**
 * WA
 */
public class Solution {
    public static boolean isSubtree(TreeNode s, TreeNode t) {
//        if(s == null && t == null){
//            return true;
//        }
//        else if((s == null && t != null) || (s != null && t == null)){
//            return false;
//        }
//        else{
//            if(s.val == t.val){
//                return (isSubtree(s.left,t.left) && isSubtree(s.right,t.right)) || (isSubtree(s.left, t) | isSubtree(s.right, t));
//            }
//            else {
//                return (isSubtree(s.left, t) | isSubtree(s.right, t));
//            }
//        }
        return helper(s,t,false);
    }

    private static boolean helper(TreeNode s, TreeNode t, boolean isSub){
        if(s == null && t == null){
            return true;
        } else if((s == null && t != null) || (s != null && t == null)){
            return false;
        }

        if(s.val == t.val){
            return helper(s.left,t.left,true) && helper(s.right,t.right,true);
        } else{
            if(isSub)
                return false;
            return helper(s.left,t,false) && helper(s.right,t,false);
        }
    }

    public static void main(String[] args){
        TreeNode a1 = new TreeNode(3);
        TreeNode a2 = new TreeNode(4);
        TreeNode a3 = new TreeNode(5);
        TreeNode a4 = new TreeNode(1);
        TreeNode a5 = new TreeNode(2);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;

        TreeNode b1 = new TreeNode(4);
        TreeNode b2 = new TreeNode(1);
        TreeNode b3 = new TreeNode(2);
        b1.left =  b2;
        b1.right = b3;

        System.out.println(isSubtree(a1,b1));

        TreeNode c1 = new TreeNode(1);
        TreeNode c2 = new TreeNode(1);
        c1.left = c2;
        TreeNode d1 = new TreeNode(1);
        System.out.println(isSubtree(c1,d1));


        TreeNode x1 = new TreeNode(3);
        TreeNode x2 = new TreeNode(4);
        TreeNode x3 = new TreeNode(5);
        TreeNode x4 = new TreeNode(1);
        TreeNode x5 = new TreeNode(2);
        x1.left = x2;
        x1.right = x3;
        x2.left = x4;
        x3.left = x5;

        TreeNode y1 = new TreeNode(3);
        TreeNode y2 = new TreeNode(1);
        TreeNode y3 = new TreeNode(2);
        y1.left = y2;
        y1.right = y3;
        System.out.println(isSubtree(x1,y1));


    }
}
