package Lead2Offer.BinaryTree;

import java.util.LinkedList;
import java.util.Stack;
/**
 * 先变镜像，再比较大小的思路有问题，会永远true
 *
 *做递归思考三步：
 *
 * 递归的函数要干什么？
 * 函数的作用是判断传入的两个树是否镜像。
 * 输入：TreeNode left, TreeNode right
 * 输出：是：true，不是：false
 *
 * 递归停止的条件是什么？
 * 1.左节点和右节点都为空 -> 倒底了都长得一样 ->true
 * 2.左节点为空的时候右节点不为空，或反之 -> 长得不一样-> false
 *
 * 3.左右节点值不相等 -> 长得不一样 -> false
 *
 * 从某层到下一层的关系是什么？
 * 要想两棵树镜像，那么一棵树左边的左边要和二棵树右边的右边镜像，一棵树左边的右边要和二棵树右边的左边镜像
 * 调用递归函数传入左左和右 && 调用递归函数传入左右和右左
 * 只有左左和右右镜像且左右和右左镜像的时候，我们才能说这两棵树是镜像的
 * 调用递归函数，我们想知道它的左右孩子是否镜像，传入的值是root的左孩子和右孩子。这之前记得判个root==null。
 */
public class SymmetricTree {


    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return match(root.left, root.right);
    }


    public static boolean match(TreeNode root, TreeNode mirror){
        if(root==null && mirror==null){
            return true;
        }
        if (root == null || mirror == null)
        {
            return false;
        }
        return root.val == mirror.val && match(root.left, mirror.right) &&
                match(root.right, mirror.left);
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


    /**
     * 这个mirror tree再比较相等的思路有问题，会存在永远相等
     * @param root
     * @return
     */
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

        mirrorTree(root);
        deptTraverse(root);


    }

    /**
     * dept print
     */
    public static void deptTraverse(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.pop();
            System.out.println(root.val);
            if (root.left != null) {
                queue.offer(root.left);

            }
            if (root.right != null) {

                queue.offer(root.right);
            }
        }
        return;
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
