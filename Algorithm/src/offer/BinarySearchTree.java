package offer;

/**
 * 每个子树木都是跟节点最大。
 */
public class BinarySearchTree {


    /**
     * 插入就是从上往下递归到的null的地方放进去，不改变原来的位置
     */
    TreeNode insertBst(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val > val) {
            root.left = insertBst(root.left, val);
        }
        if (root.val < val) {
            root.right = insertBst(root.right, val);
        }
        return root;
    }

    //删除
    TreeNode deleteBst(TreeNode root, int val) {
        if (root == null) return null;
        /**
         * 三种情况：
         * 1：A 恰好是末端节点，两个子节点都为空，可以直接删掉。
         * 2: 左右其中一个在，接替
         * 3：左右都在，找，左子树里最大那个接替，或者找右子树最小接替
         */
        if (root.val == val) {
            //1.
            if (root.left == null && root.right == null) {
                return null;
            }
            //2
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            //3
            if (root.left != null && root.right != null) {
                TreeNode minNode = getMin(root.right);
                // 把 root 改成 minNode
                root.val = minNode.val;
                // 转而去删除 minNode
                root.right = deleteBst(root.right, minNode.val);
            }
        } else if (root.val > val) {
            root.left = deleteBst(root.left, val);
        } else {
            root.right = deleteBst(root.right, val);
        }
        return root;
    }

    TreeNode getMin(TreeNode node) {
// BST 最左边的就是最小的
        while (node.left != null) node = node.left;
        return node;
    }
    boolean isValidBst(TreeNode root) {
        if (root == null) return true;
        return isValidBst(root, null, null);
    }


    private boolean isValidBst(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) return true;

        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;
        return isValidBst(root.left, min, root)
                && isValidBst(root.right, root, max);

    }

    boolean isInBST(TreeNode root, int target) {
        if (root == null) return false;
        if (root.val == target) {
            return true;
        }
        if (root.val > target) {
            return isInBST(root.left, target);
        }
        return isInBST(root.right, target);
    }


    static class TreeNode {
        TreeNode left;// 左节点(儿子)
        TreeNode right;// 右节点(儿子)
        Integer val;// 数据

        TreeNode(Integer val) {
            this.val = val;
        }
    }

}
