package DataStructure.tree;

/**
 * TODO
 *
 * @author yangshu
 * @version 5.0.0
 * @created at 2020/7/13-11:42 PM
 * copyright @2020 Beijing Morong Information Techology CO.,Ltd.
 */
public class IsSymmetric {
    //左子树根节点和右子树根节点是否相等
    //左子树的左左子树木是否和右子树的右右子树对称，
    //左子树的左右子树木是否和右子树的右左对称

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }
        return compare(root.left, root.right);

    }

    public boolean compare(TreeNode root, TreeNode mirror) {

        if (root == null && mirror == null) {
            return true;
        }
        if (root == null || mirror == null) {
            return false;
        }
        return root.val.equals(mirror.val) && compare(root.left, mirror.right) && compare(root.right, mirror.left);
    }
}
