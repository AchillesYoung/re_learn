package offer;

public class BinaryTree {
    /**
     * 普通二叉树
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    /**
     * 完全二叉树节点
     */
    int countNodes4PerfectTree(TreeNode root) {

        if (root == null) return 0;

        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);

        if (leftDepth == rightDepth) return 1 << leftDepth + countNodes(root.right);
        else return 1 << rightDepth + countNodes(root.left);
    }


    int getDepth(TreeNode root) {
        int depth = 0;
        if (root == null) return depth;
        while (root != null) {
            depth++;
            root = root.left;
        }
        return depth;
    }

    static class TreeNode {
        TreeNode left;// 左节点(儿子)
        TreeNode right;// 右节点(儿子)
        int val;// 数据

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        System.out.println(1 << 4);
    }


}
