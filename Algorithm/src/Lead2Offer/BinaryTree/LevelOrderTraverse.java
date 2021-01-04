package Lead2Offer.BinaryTree;

import java.util.*;

public class LevelOrderTraverse {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<List<Integer>>();

        if (root == null) {
            return resList;
        }
        //双端队列
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        //pop配合push是栈，头进头出
        //offer配合poll是队列，尾巴进头出

        deque.offer(root);
        while (!deque.isEmpty()) {
            //每次都new一个新的list
            List<Integer> level = new ArrayList<Integer>();
            //关键点，每次循环之前计算下当前父节点有几个，把
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


//        Deque<Integer> queue = new LinkedList<>();
//        queue.push(1);
//        queue.push(2);
//        queue.push(3);
//        queue.push(null);
//        queue.push(5);
//
//        System.out.println(queue);
//        System.out.println(queue.pop());//removeFirst模拟了栈FILO,
//        Integer pop = queue.pop();
//        if (pop == null) {
//            System.out.println(pop + "null");
//        }
//        System.out.println(queue.pop());//removeFirst模拟了栈FILO,
//        System.out.println(queue.pop());
//        System.out.println(queue.pop());
//
//
////        System.out.println("栈push+Last:"+queue.getLast());
////        System.out.println("栈push+first:"+queue.getFirst());
//
//        System.out.println(queue.offer(4));//addLast模拟了队列,尾巴进头出
//        System.out.println(queue.offer(5));//addLast模拟了队列,尾巴进头出
//        System.out.println(queue.offer(6));//addLast模拟了队列,尾巴进头出
//        System.out.println(queue.poll());//addLast模拟了队列,尾巴进头出


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

    static Deque<TreeNode> queue = new LinkedList<>();


    public static int getDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
