package DataStructure.tree;

import QuestionMet.BinaryTree;

import java.util.*;

/**
 * stack写递归
 */
public class TraverseStack {
    private static TreeNode root;
    static Stack<TreeNode> stack = new Stack<>();

    public static void prePrintStack(TreeNode root) {
        System.out.print("pre-order: ");
        /**
         * 这里外围循环我忘记了增加条件|| root !=null，不然弹到根了，切不到右边。会进不来,考虑极限情况图2,在外面压会两个root
         */
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                /**
                 * 先把root节点root.left循环直接压到底，直到node==null停止
                 */
                System.out.print(root.val + " ");
                stack.push(root);
                root = root.left;
            }
            /**
             * 再弹出栈里面的节点
             * 只要node！=null ｜｜ ！stack.isEmpty就一直循环到底（考虑极限情况图1）所以外圈的判断条件是root!=null
             * 1。弹的时候还要push进去，然后外围循环还要进第一个循环去stack左到底
             * !这里我忘记了if 判断再pop
             */
            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }
    }

    /**
     * 方法2，抽象化
     *
     * @param head
     */
    public static void preOrderUnRecur(TreeNode head) {
        System.out.print("pre-order: ");
        if (head == null) {
            return;
        }
        //分尔治之
        stack.add(head);
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

    public static void midPrintStack(TreeNode root) {
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

    public static void posOrderUnRecur1(TreeNode head) {
        System.out.print("pos-order: ");
        if (head != null) {
            return;
        }

        /**
         * left-right-mid
         *  这里需要两个stack，
         *  第一个放的节点pop出来的左右节点，pop出去的节点都要放在stack2里面
         *  这样，stack2里面按照后序的顺序。排好序放着，直接pop打印，直到empty结束
         *  s1 一个循环里面，pop(中间节点）然后push(left)和push(right),这样导入到s2的顺序就是mid-right-left
         *  s2 的pop顺序就变成 left-right-mid
         */
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


    public static TreeNode kthSmall(TreeNode root, int k) {

        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) {
                return root;
            }
            System.out.println(root.val);
            root = root.right;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    public static void main(String[] args) {
        preOrderIterator(root);
        System.out.println("-----");
//        System.out.println(kthSmall(root, 3).val);
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
        TreeNode treeNode11 = new TreeNode(11);
//        TreeNode treeNode13= new TreeNode(13);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
//        treeNode6.right=treeNode13;
        treeNode3.right = treeNode7;
        treeNode4.left = treeNode8;
        treeNode4.right = treeNode9;
        treeNode5.left = treeNode10;
        treeNode5.right = treeNode11;
        root = treeNode1;
    }
}
