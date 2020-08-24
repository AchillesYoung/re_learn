package DataStructure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * TODO
 *
 * @author yangshu
 * @version 5.0.0
 * @created at 2020/7/13-10:38 PM
 * copyright @2020 Beijing Morong Information Techology CO.,Ltd.
 */
public class ReverseBinaryTree {

    /**
     * 从上往下分而治之
     * @param root
     * @return
     */
    public static TreeNode reverseTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = reverseTree(root.right);
        root.right = reverseTree(tmp);
        return root;
    }

    public static void reverseTree2(TreeNode root) {

        if (root == null) {
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        reverseTree2(root.left);
        reverseTree2(root.right);
        return;
    }


    /**
     * 用栈深度遍历的同时进行置换,辅助栈模拟递归了
     *
     * @param root
     * @return
     */
    public static TreeNode mirrorTreeStack(TreeNode root) {

        if (root == null) {
            return root;
        }
        //从上而下的翻转
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            /**
             *  把右子树的根压进去，左子树的根也压进去（先后顺序无所谓，因为只关注翻转
             *  然后再调转left和right，再次弹出的时候，先右边再左。父节点已经链接翻转过的
             */
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
            /**
             * 重点部分
             */
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
        }
        return root;
    }

    public static void main(String[] args) {
//        System.out.println("----");
//        reverseTree2(root);
//        System.out.println("----");
//        bfs(root);
        System.out.println("----");
        mirrorTreeStack(root);
        System.out.println("----");
        bfs(root);


    }

    private static TreeNode root;

    static {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        root = treeNode1;
    }

    /**
     * level print 层次遍历基本
     */
    public static void bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            System.out.println(root.val);
            if (root.left != null) {
                queue.offer(root.left);
            }
            if (root.right != null) {

                queue.offer(root.right);
            }
        }
    }
}
