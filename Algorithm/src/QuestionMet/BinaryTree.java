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
                 * �Ȱ�root�ڵ�root.leftѭ��ֱ��ѹ���ף�ֱ��node==nullֹͣ,���̲���ӡ��һֱ��������
                 */
//                System.out.println(root.val);
                stack.push(root);
                root = root.left;
            } else {
                /**
                 * �������ˣ��ٵ���ջ����Ľڵ㣬��ӡ����ʱ������"null-��-null"
                 * ֻҪnode��=null ���� ��stack.isEmpty��һֱѭ�����ף����Ǽ������ͼ1��������Ȧ���ж�������root!=null
                 * 1������ʱ��Ҫpush��ȥ��Ȼ����Χѭ����Ҫ����һ��ѭ��ȥstack�󵽵�
                 * !������������if �ж���pop
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
