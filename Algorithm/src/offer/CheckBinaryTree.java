package offer;

public class CheckBinaryTree {


    boolean isBst(TreeNode root) {
        if (root == null) return true;

        return isBst(root, null, null);
    }

    private boolean isBst(TreeNode root, TreeNode min, TreeNode max) {
        //ɲ������
        if (root == null) return true;

        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;
        return isBst(root.left, min, root) && isBst(root.right, root, max);
    }


    boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }

    /**
     * ��ת������,��ת���赽���ڵ��ˣ���������������������Ѿ���ת����
     */
    TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode right = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(right);
        return root;
    }

    static class TreeNode {
        TreeNode left;// ��ڵ�(����)
        TreeNode right;// �ҽڵ�(����)
        int val;// ����

        TreeNode(Integer val) {
            this.val = val;
        }
    }
}
