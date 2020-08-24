package DataStructure.tree;

/**
 * TODO
 *
 * @author yangshu
 * @version 5.0.0
 * @created at 2020/8/12-10:56 PM
 * copyright @2020 Beijing Morong Information Techology CO.,Ltd.
 */
public class CBTNodeNumber {


    private int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return 1;
        }

        if (getDepth(root.left) == getDepth(root.right)) {
            return 2 >> getDepth(root.left) - 1 + countNodes(root.right);
        }else {

            return 2 >> getDepth(root.right) - 1 + countNodes(root.left);
        }

    }
    private int getDepth(TreeNode root){
        int dept =0;
        while (root != null){
            root = root.left;
            dept++;
        }
        return dept;
    }
}
