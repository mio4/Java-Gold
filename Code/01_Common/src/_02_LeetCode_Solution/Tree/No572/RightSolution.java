package _02_LeetCode_Solution.Tree.No572;

public class RightSolution {
    private boolean isSub = false;
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null){
            return false;
        }
        isSub = verify(s,t);
        if(!isSub){
            isSubtree(s.left,t);
        }
        if(!isSub){
            isSubtree(s.right,t);
        }
        return isSub;
    }

    private boolean verify(TreeNode s, TreeNode t){
        if(s == null && t == null){
            return true;
        }
        if(s == null || t == null){
            return false;
        }
        if(s.val != t.val){
            return false;
        }
        return verify(s.left,t.left) && verify(s.right,t.right);
    }
}
