package QuestionMet;

import java.util.Deque;
import java.util.LinkedList;

public class BstFindKth {

    /**
     * 思路利用bst性质，找到第k小的，就是判断跟节点。
     * 跟节点左边左子树节点数量>k就是在左边，小于k节点在右边，等于k命中。
     */
    private class ResultType {
        boolean found;  // 是否找到
        int val;  // 节点数目
        ResultType(boolean found, int val) {
            this.found = found;
            this.val = val;
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        return kthSmallestHelper(root, k).val;
    }

    private ResultType kthSmallestHelper(TreeNode root, int k) {
        if (root == null) {
            return new ResultType(false, 0);
        }

        ResultType left = kthSmallestHelper(root.left, k);
        // 左子树找到，直接返回
        if (left.found) {
            return new ResultType(true, left.val);
        }

        // 左子树的节点数目 = K-1，结果为 root 的值
        if (k - left.val == 1) {
            return new ResultType(true, root.val);
        }

        // 右子树寻找
        ResultType right = kthSmallestHelper(root.right, k - left.val - 1);
        if (right.found) {
            return new ResultType(true, right.val);
        }

        // 没找到，返回节点总数
        return new ResultType(false, left.val + 1 + right.val);
    }


    public static int index = 0;
    // 递归版本,找中序遍历的第k个
    public static TreeNode kthNode(TreeNode root, int k) {
        if (root != null) {
            TreeNode node = kthNode(root.left, k);
            if (node != null) {
                return node;
            }
            index++;
            if (index == k) {
                return root;
            }
            node = kthNode(root.right, k);
            if (node != null) {
                return node;
            }
        }
        return null;

    }

    // 非递归版本
    public static TreeNode kthNode2(TreeNode root, int k) {
        if (root == null || k == 0)
            return null;
        int count = 0;
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            count++;
            if (count == k)
                return root;
            root = root.right;
        }
        return null;
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
