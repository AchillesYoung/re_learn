package DataStructure.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * TODO
 *
 * @author yangshu
 * @version 5.0.0
 * @created at 2020/7/26-11:02 AM
 * copyright @2020 Beijing Morong Information Techology CO.,Ltd.
 */
public class CheckTree {

    /**
     * 判断是否平衡树，先考虑完所有情况
     * if
     * 1. node == null Return true;
     * 2. left child tree is BST? If true return height+true else return false+0
     * 3. right child tree is Bst? if true return height+true else false.
     * 4. abs |left child tree high - right child tree high|>2. if true return true+height else return false.
     * else
     * return current node height = max(left child tree high, left child tree high )+1;
     * //     *问题出在，情况考虑完了，但是没有递归的动作
     */
    ChildTree isBalance(TreeNode node) {

        if (node == null) {
            return new ChildTree(0, true);
        }

        if (isBalance(node.left).flag) {
            return new ChildTree(0, false);
        }
        if (isBalance(node.right).flag) {
            return new ChildTree(0, false);

        }
        if (Math.abs(isBalance(node.right).height - isBalance(node.left).height) > 1) {
            return new ChildTree(0, false);
        }
        int height = Math.max(isBalance(node.left).height, isBalance(node.right).height);
        return new ChildTree(height + 1, true);

    }

    class ChildTree {
        private int height;
        private boolean flag;

        public ChildTree(int height, boolean flag) {
            this.height = height;
            this.flag = flag;
        }
    }

    /**
     * 考虑三种情况，遍历的过程中吧，遍历使用层序遍历，遍历使用queue
     * 1。节点有右边子节点，没有左边子节点 直接return false
     * <p>
     * 3。节点有左边孩子，也有右边孩子，那么继续递归
     * 2。节点有左边孩子，但是没有右边孩子，那么后续节点都应该是叶子节点，否则return false
     * 情况的考虑中，我们只考虑不是cst的情况，return false/别的情况我们按照正常的流程层次处理
     *
     * @param head
     * @return
     */
    boolean isCompleteTree(TreeNode head) {


        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        TreeNode left = null;
        TreeNode right = null;
        boolean flag = false;
        while (queue.isEmpty()) {
            head = queue.poll();
            left = head.left;
            right = head.right;
            if ((left == null && right != null) ||
                    (flag && (left != null || right != null))) {
                return false;
            }
            if (left != null) {
                queue.offer(head.left);
            }
            if (right != null) {
                queue.offer(head.right);
            } else {
                //这里我们已经把left==null，right！=null的特殊情况抛开了
                //所以只会是left！=null，right==null，开启leaf模式
                flag = true;
            }
            //相比下面我自己写的，上面的层次过程可读性更强
            //没有开启，没有开启要考虑进queue,继续递归
//            if (!flag && (head.left != null && head.right == null)) {
//                flag = true;
//                queue.offer(head.left);
//            }
//            if (head.right != null && head.right != null) {
//                queue.offer(head.left);
//                queue.offer(head.right);
//
//            }
        }
        return true;

    }


    public static int completeTreeNodeNum(TreeNode head) {
        if (head == null) {
            return 0;
        }
        return bs(head, 1, mostLeftLevel(head, 1));
    }

    public static int bs(TreeNode node, int level, int h) {
        if (level == h) {
            return 1;
        }
        if (mostLeftLevel(node.right, level + 1) == h) {
            //右子树最左边等于high。所以左子树是完全二叉树
            return (1 << (h - level)) + bs(node.right, level + 1, h);
        } else {
            //右子树最左边不等于high。所以右子树是完全二叉树，但是高度少1
            return (1 << (h - level - 1)) + bs(node.left, level + 1, h);
        }
    }

    public static int mostLeftLevel(TreeNode node, int level) {
        while (node != null) {
            level++;
            node = node.left;
        }
        return level - 1;
    }

   static class person {

    }
    static class student extends person{

    }
    public static void main(String[] args) {
//        ArrayList<person> arr = new ArrayList<>();
//        arr.add(new person());
//        Object [] arr2 = arr.toArray();
//        person [] arr3 = Arrays.copyOfRange(arr2, 0, arr2.length,student [].class);
//        System.out.println(arr3);

        TreeNode root = new TreeNode(1);
        TreeNode tmp = null;
        TreeNode node = new TreeNode(2);

        tmp = root;

        root.left = node;
        root = root.left;
        System.out.println(tmp.val);
        System.out.println(root.val);
    }

}
