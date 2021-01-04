package QuestionMet;

import java.util.Deque;
import java.util.LinkedList;

public class BstFindKth {

    /**
     * ˼·����bst���ʣ��ҵ���kС�ģ������жϸ��ڵ㡣
     * ���ڵ�����������ڵ�����>k��������ߣ�С��k�ڵ����ұߣ�����k���С�
     */
    private class ResultType {
        boolean found;  // �Ƿ��ҵ�
        int val;  // �ڵ���Ŀ
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
        // �������ҵ���ֱ�ӷ���
        if (left.found) {
            return new ResultType(true, left.val);
        }

        // �������Ľڵ���Ŀ = K-1�����Ϊ root ��ֵ
        if (k - left.val == 1) {
            return new ResultType(true, root.val);
        }

        // ������Ѱ��
        ResultType right = kthSmallestHelper(root.right, k - left.val - 1);
        if (right.found) {
            return new ResultType(true, right.val);
        }

        // û�ҵ������ؽڵ�����
        return new ResultType(false, left.val + 1 + right.val);
    }


    public static int index = 0;
    // �ݹ�汾,����������ĵ�k��
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

    // �ǵݹ�汾
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
