package Lead2Offer.BinaryTree;

import java.util.*;

public class LevelOrderTraverse {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        List<List<Integer>> resList2 = new LinkedList<>();

        if (root == null) {
            return resList;
        }
        //˫�˶���
        Deque<TreeNode> deque = new LinkedList<TreeNode>();

        deque.offer(root);
        while (!deque.isEmpty()) {
            //ÿ�ζ�newһ���µ�list
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = deque.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = deque.poll();
                level.add(node.val);
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            resList.add(level);
        }
        return resList;
    }


    static Deque<TreeNode> queue = new LinkedList<>();



    public static int getDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3, 9, 20, null, null, 15, 7};


        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
        TreeNode node3 = null;
        TreeNode node4 = null;
//        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        System.out.println(levelOrder(root));

//        Deque<Integer> queue = new LinkedList<>();
//        queue.push(1);
//        queue.push(2);
//        queue.push(3);
//        queue.push(null);
//        queue.push(5);
//
//        System.out.println(queue);
//        //pop���push��ջ��ͷ��ͷ��
//        System.out.println(queue.pop());//removeFirstģ����ջFILO,
//        Integer pop = queue.pop();
//        if (pop == null) {
//            System.out.println(pop + "null");
//        }
//        System.out.println(queue.pop());//removeFirstģ����ջFILO,
//        System.out.println(queue.pop());
//        System.out.println(queue.pop());
//
//
////        System.out.println("ջpush+Last:"+queue.getLast());
////        System.out.println("ջpush+first:"+queue.getFirst());
//        //offer���poll�Ƕ��У�β�ͽ�ͷ��
//
//        System.out.println(queue.offer(4));//addLastģ���˶���,β�ͽ�ͷ��
//        System.out.println(queue.offer(5));//addLastģ���˶���,β�ͽ�ͷ��
//        System.out.println(queue.offer(6));//addLastģ���˶���,β�ͽ�ͷ��
//        System.out.println(queue.poll());//addLastģ���˶���,β�ͽ�ͷ��

    }

    public static List<List<Integer>> levelOrderTimeOut(TreeNode root) {
        queue.offer(root);
        ArrayList<List<Integer>> res = new ArrayList<>();
        int level = 0;
        int depth = getDepth(root);
        while (level < depth) {
            int levelNums = 1 << level;
            List<Integer> levelList = new ArrayList<>();

            Deque<TreeNode> prevLevel = new LinkedList<>();
            for (; levelNums > 0; --levelNums) {
                TreeNode poll = queue.poll();
                prevLevel.offer(poll);
                if (poll != null) {
                    levelList.add(poll.val);
                }
            }
            while (prevLevel.size() != 0) {
                TreeNode poll = prevLevel.poll();
                if (poll != null) {
                    queue.offer(poll.left);
                    queue.offer(poll.right);
                }

            }
            res.add(levelList);
            level++;
        }
        return res;
    }
}
