package _03_SwordOnOffer;

public class Util {


    /**
     * 生成一颗二叉树
     *           8
     *         6  10
     *        5 7 9 11
     * @return root
     */
    public static TreeNode generateBinaryTree(){
        TreeNode root = new TreeNode(8);
        TreeNode n1 = new TreeNode(6);
        TreeNode n2 = new TreeNode(10);
        root.left = n1;
        root.right = n2;

        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(7);
        TreeNode n5 = new TreeNode(9);
        TreeNode n6 = new TreeNode(11);
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;

        return root;
    }

    /**
     *              5
     *          3       3
     *        4            4
     *      2   2            1
    * @return
     */
    public static TreeNode generateBinaryTree2(){
        TreeNode root = new TreeNode(5);
        TreeNode n11 = new TreeNode(3);
        TreeNode n12 = new TreeNode(3);
        root.left = n11;
        root.right = n12;

        TreeNode n21 = new TreeNode(4);
        TreeNode n22 = new TreeNode(4);
        n11.left = n21;
        n12.right = n22;

        TreeNode n31 = new TreeNode(2);
        TreeNode n32 = new TreeNode(2);
        TreeNode n33 = new TreeNode(1);
        n21.left = n31;
        n21.right = n32;

        n22.right = n33;
        return root;
    }
}
