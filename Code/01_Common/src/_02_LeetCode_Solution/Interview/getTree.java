package _02_LeetCode_Solution.Interview;

public class getTree {

    public static TreeNode get1(){
        TreeNode root = new TreeNode(1);
        TreeNode r1 = new TreeNode(2);
        TreeNode r2 = new TreeNode(3);
        TreeNode r3 = new TreeNode(4);
        TreeNode r4 = new TreeNode(5);

        root.right = r1;
        r1.right = r2;
        r2.right = r3;
        r3.right = r4;

        return root;
    }


    public static TreeNode get2(){
        TreeNode root = new TreeNode(1);
        TreeNode r1 = new TreeNode(3);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(5);
        TreeNode r4 = new TreeNode(3);
        TreeNode r5 = new TreeNode(9);
        root.left = r1;
        root.right = r2;
        r1.left = r3;
        r1.right = r4;
        r2.right = r5;
        return root;
    }


    public static TreeNode get3(){
        TreeNode root = new TreeNode(1);
        TreeNode r1 = new TreeNode(3);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(5);
        TreeNode r4 = new TreeNode(9);
        TreeNode r5 = new TreeNode(6);
        TreeNode r6 = new TreeNode(7);
        root.left = r1;
        root.right = r2;
        r1.left = r3;
        r2.right = r4;
        r3.left = r5;
        r4.right = r6;
        return root;
    }
}
