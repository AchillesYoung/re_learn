package offer;

/**
 * ÿ������ľ���Ǹ��ڵ����
 */
public class BinarySearchTree {


    /**
     * ������Ǵ������µݹ鵽��null�ĵط��Ž�ȥ�����ı�ԭ����λ��
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

    //ɾ��
    TreeNode deleteBst(TreeNode root, int val) {
        if (root == null) return null;
        /**
         * ���������
         * 1��A ǡ����ĩ�˽ڵ㣬�����ӽڵ㶼Ϊ�գ�����ֱ��ɾ����
         * 2: ��������һ���ڣ�����
         * 3�����Ҷ��ڣ��ң�������������Ǹ����棬��������������С����
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
                // �� root �ĳ� minNode
                root.val = minNode.val;
                // ת��ȥɾ�� minNode
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
// BST ����ߵľ�����С��
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
        TreeNode left;// ��ڵ�(����)
        TreeNode right;// �ҽڵ�(����)
        Integer val;// ����

        TreeNode(Integer val) {
            this.val = val;
        }
    }

}
