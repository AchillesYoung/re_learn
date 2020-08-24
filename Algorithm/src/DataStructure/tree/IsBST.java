package DataStructure.tree;

import java.util.Stack;

/**
 * TODO
 *
 * @author yangshu
 * @version 5.0.0
 * @created at 2020/7/16-1:15 AM
 * copyright @2020 Beijing Morong Information Techology CO.,Ltd.
 */
public class IsBST {

    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;

        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        if (! helper(node.right, val, upper)) return false;
        if (! helper(node.left, lower, val)) return false;
        return true;
    }

    public boolean isBSTRecur(TreeNode root) {
        return helper(root, null, null);
    }


    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        Integer inorder = Integer.MIN_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }


}
