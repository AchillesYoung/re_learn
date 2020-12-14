package DataStructure.tree;

import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * TODO
 * 二叉树遍历有三种方式
 * 前序遍历：根->左->右
 * 中序遍历：左->根->右
 * 后序遍历：左->右->根
 */
public class TraverseRecursive {
    private static TreeNode root;

    /**
     * 写完忘记了递归的刹车停止条件
     *
     * @param root
     */
    public static void prePrintRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + "->");
        prePrintRecursive(root.left);
        prePrintRecursive(root.right);
    }

    public static void midPrintRecursive(TreeNode root) {

        if (root == null) {
            return;
        }
        midPrintRecursive(root.left);
        System.out.print(root.val + "->");
        midPrintRecursive(root.right);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorderList = new ArrayList<>();
        if (root == null) {
            return new ArrayList<>();
        }

        inorderRecur(root, inorderList);
        return inorderList;
    }

    static void inorderRecur(TreeNode root, List<Integer> inorderList) {
        if (root == null) {
            return;
        }
        inorderRecur(root.left, inorderList);
        System.out.println(root.val);
        inorderList.add(root.val);
        inorderRecur(root.right, inorderList);
    }

    public static void postPrintRecursive(TreeNode root) {

        if (root == null) {
            return;
        }
        postPrintRecursive(root.left);
        postPrintRecursive(root.right);
        System.out.print(root.val + "->");
    }

    public static void main(String[] args) {
        midPrintRecursive(root);
        System.out.println("root:" + root.val);
        List<Integer> integers = inorderTraversal(root);
//        Arrays.toString(integers);

        System.out.println(integers);
    }

    static {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode10 = new TreeNode(10);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        treeNode4.left = treeNode8;
        treeNode4.right = treeNode9;
        treeNode5.left = treeNode10;
        root = treeNode1;
    }

}
