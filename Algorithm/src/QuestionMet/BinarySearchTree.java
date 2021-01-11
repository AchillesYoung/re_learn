package QuestionMet;

public class BinarySearchTree {

    //�ж������������Ƿ���ͬ
    boolean isSameTree(TreeNode root1, TreeNode root2) {
        // root ��Ҫ��ʲô?��������
        // �����Ĳ��� root ���ģ��׸���
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;
        return isSameTree(root1.left, root2.left)
                && isSameTree(root2.left, root1.left);
    }


    boolean isBst(TreeNode root) {
        return isBst(root, null, null);
    }

    boolean isBst(TreeNode root, TreeNode max, TreeNode min) {
        // root ��Ҫ��ʲô?��������
        // �����Ĳ��� root ���ģ��׸���
        if (root == null) return true;
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;

        return isBst(root.left, root, min)
                && isBst(root.right, root, max);
    }


    //
    boolean isInBst(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.val == target) return true;
        if (root.val > target) {
            return isInBst(root.left, target);
        }
        if (root.val < target) {
            return isInBst(root.right, target);
        }
        return false;
    }

    TreeNode insert2Bst(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val > val) {
            root.left = insert2Bst(root.left, val);
        }
        if (root.val > val) {
            root.right = insert2Bst(root.right, val);
        }
        return root;
    }

    //ɾ��
    TreeNode deleteNodeInBst(TreeNode root, int val) {
        if (root.left == null && root.right == null)
            return null;

        if (root.left == null) return root.right;
        if (root.right == null) return root.left;

        if (root.left != null && root.right != null) {
            // �ҵ�����������С�ڵ�
            TreeNode minNode = getMin(root.right);
            // �� root �ĳ� minNode
            root.val = minNode.val;
            root.right = deleteNodeInBst(root.right, minNode.val);
        }
        return root;
    }

    TreeNode getMin(TreeNode node) {
    // BST ����ߵľ�����С��
        while (node.left != null) node = node.left; return node;
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
