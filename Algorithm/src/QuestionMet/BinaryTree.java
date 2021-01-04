package QuestionMet;

import DataStructure.tree.TreeNode;

import java.util.*;
import java.util.LinkedList;

public class BinaryTree {

    public static void midPrintStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                /**
                 * 先把root节点root.left循环直接压到底，直到node==null停止,过程不打印，一直在找最左。
                 */
//                System.out.println(root.val);
                stack.push(root);
                root = root.left;
            } else {
                /**
                 * 到最左了，再弹出栈里面的节点，打印，此时当作是"null-中-null"
                 * 只要node！=null ｜｜ ！stack.isEmpty就一直循环到底（考虑极限情况图1）所以外圈的判断条件是root!=null
                 * 1。弹的时候还要push进去，然后外围循环还要进第一个循环去stack左到底
                 * !这里我忘记了if 判断再pop
                 */
                root = stack.pop();
                System.out.println(root.val);
                root = root.right;
            }
        }
    }
    public static void preOrderIterator(TreeNode root){
        Deque<TreeNode> queue = new LinkedList();

        while (!queue.isEmpty() || root !=  null){
            while (root !=  null){
                System.out.println(root.val);
                queue.push(root);
                root = root.left;
            }
            if (!queue.isEmpty()) {
                root = queue.pop();
                root = root.right;
            }
        }
    }

    //mid left right
    public static void preOrderUnRecur(TreeNode head) {
        System.out.print("pre-order: ");
        if (head == null) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            System.out.print(head.val + " ");
            if (head.right != null) {
                stack.push(head.right);
            }
            if (head.left != null) {
                stack.push(head.left);
            }
        }
        System.out.println();
    }
    public static void posOrderUnRecur1(TreeNode head) {
        System.out.print("pos-order: ");
        if (head != null) return;
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        s1.push(head);
        while (!s1.isEmpty()) {
            head = s1.pop();
            s2.push(head);
            if (head.left != null) {
                s1.push(head.left);
            }
            if (head.right != null) {
                s1.push(head.right);
            }
        }
        while (!s2.isEmpty()) {
            System.out.print(s2.pop().val + " ");
        }
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
