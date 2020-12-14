package Lead2Offer.BinaryTree;

/**
 * @author yangshu
 * @version Id: CompleteBinaryTree.java, v 0.1 2020/12/14 9:59 AM yangshu Exp $$
 */
public class CompleteBinaryTree {

    public int countNode(TreeNode root) {
        TreeNode cur = new TreeNode(0);
        cur = root;
        int leftDepth = 0, rightDepth = 0;
        while (cur != null) {
            leftDepth++;
            cur = cur.left;
        }
        cur = root;

        //log(n)
        while (cur != null) {
            rightDepth++;
            cur = cur.right;
        }

        if (leftDepth != rightDepth)
            return 1 + countNode(root.left) + countNode(root.right);
        else {
            return (int) Math.pow(2, leftDepth) - 1;
        }
    }

}
