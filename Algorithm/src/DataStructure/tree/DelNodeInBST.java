package DataStructure.tree;

import java.util.ArrayList;

/**
 * TODO
 *
 * @author yangshu
 * @version 5.0.0
 * @created at 2020/8/12-11:13 PM
 * copyright @2020 Beijing Morong Information Techology CO.,Ltd.
 */
public class DelNodeInBST {

//    一般来说，删除节点可分为两个步骤：
//
//    首先找到需要删除的节点；
//    如果找到了，删除它。
//    说明： 要求算法时间复杂度为 O(h)，h 为树的高度。

    //找bst中序遍历的后续节点

    /**
     * 找到该节点的右子节点，遍历其左子节点，直到node.left == null，则node就是目标节点的后续节点
     */
    public int findSuccessor(TreeNode node) {

        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
        }
        return node.val;
    }

    public int findPredecessor(TreeNode root) {

        if (root.left != null) {
            root = root.left;
            while (root.right != null) root = root.right;
        }

        return root.val;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        // delete from the right subtree
        if (key > root.val) root.right = deleteNode(root.right, key);
            // delete from the left subtree
        else if (key < root.val) root.left = deleteNode(root.left, key);
            // delete the current node
        else {
            // the node is a leaf
            if (root.left == null && root.right == null) root = null;
                // the node is not a leaf and has a right child
            else if (root.right != null) {
                //先吧当前节点的值换成后续节点，再去删除后续节点（递归）
                root.val = findSuccessor(root);
                root.right = deleteNode(root.right, root.val);
            }
            // the node is not a leaf, has no right child, and has a left child
            else {
                root.val = findPredecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }

        return root;
    }


}
