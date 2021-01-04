package QuestionMet;

public class AVLTree {


    boolean isBalanced = true;

    public boolean IsBalanced_Solution(TreeNode root) {

        getDepth(root);
        return isBalanced;
    }

    public int getDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);

        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }
        return Math.max(left, right) + 1;
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
