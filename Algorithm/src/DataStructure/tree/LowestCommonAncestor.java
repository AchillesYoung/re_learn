package DataStructure.tree;

import java.util.Stack;

/**
 * TODO
 *
 * @author yangshu
 * @version 5.0.0
 * @created at 2020/8/14-11:38 PM
 * copyright @2020 Beijing Morong Information Techology CO.,Ltd.
 */
public class LowestCommonAncestor {
    /**
     * 递归方法找二叉搜索树的共同祖先
     * 从根节点开始遍历树
     * 如果节点 pp 和节点 qq的值都比当前根节点大，就是都在右子树上，那么以右孩子为根节点继续 1 的操作
     * 如果节点 pp 和节点 qq的值都小于当前节点，就是都在左子树上，那么以左孩子为根节点继续 1 的操作
     * 如果条件 2 和条件 3 都不成立，这就意味着我们已经找到节 pp 和节点 qq 的 LCA 了
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }
        // val of current node or parent node.
        int parentVal = root.val;
        // val of p   // val of q;
        if (p.val > parentVal && q.val > parentVal) {
            // If both p and q are greater than parent
            return lowestCommonAncestor(root.right, p, q);
        } else if (p.val < parentVal && q.val < parentVal) {
            // If both p and q are lesser than parent
            return lowestCommonAncestor(root.left, p, q);
        } else {
            // We have found the split point, i.e. the LCA node.
            return root;
        }
    }

    public TreeNode lowestCommonAncestorUnRecur(TreeNode root, TreeNode p, TreeNode q) {
        // Start from the root node of the tree Traverse the tree
        while (root != null) {
            // val of ancestor/parent node.
            int parentVal = root.val;
            if (p.val > parentVal && q.val > parentVal) {
                // If both p and q are greater than parent
                root = root.right;
            } else if (p.val < parentVal && q.val < parentVal) {
                // If both p and q are lesser than parent
                root = root.left;
            } else {
                // We have found the split point, i.e. the LCA node.
                return root;
            }
        }
        return null;
    }


    TreeNode getLCA(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null) return null;
        if (root == node1 || root == node2) return root;

        TreeNode left = getLCA(root.left, node1, node2);
        TreeNode right = getLCA(root.right, node1, node2);

        // node1 和 node2 不存在祖先关系
        if (left != null && right != null) return root;
            // node1 和 node2 其中一个是另一个的祖先
        else if (left != null) return left;
        else if (right != null) return right;
        else return null;
    }

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> help = new Stack<>();

        while (true) {
            while (root != null) {
                help.add(root.left);
                root = root.left;
            }
            root = help.pop();
            if (--k == 0) {
                return root.val;
            }
            root = root.right;
        }
    }


}
