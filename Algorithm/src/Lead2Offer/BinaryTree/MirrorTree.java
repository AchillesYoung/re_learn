package Lead2Offer.BinaryTree;

import java.util.Stack;

/**
 * 还是递归
 */
public class MirrorTree {
    public static TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
//        root.right= mirrorTree(root.left);
//        root.left = mirrorTree(root.right);
        return root;
    }

    public static void main(String[] args) {


        System.out.println(mirrorTreeStack(root).left.left.val);
    }

    /**
     * 用栈深度遍历进行置换,辅助栈模拟递归了其实
     * @param root
     * @return
     */
    public static TreeNode mirrorTreeStack(TreeNode root) {

        if(root==null){
            return root;
        }
        Stack<TreeNode> stack =new Stack<>();
        stack.push(root);
        TreeNode node;
        while (!stack.isEmpty()){
            node = stack.pop();
            if(node.left!=null){
                stack.push(node.left);
            }
            if(node.right!=null){
                stack.push(node.right);
            }
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }



    static TreeNode root;

    static {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(17);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        root = treeNode1;
    }



}
