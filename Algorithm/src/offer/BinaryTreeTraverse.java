package offer;


import java.util.LinkedList;
import java.util.*;

public class BinaryTreeTraverse {
    //层序遍历
    public static List<List<Integer>> levelOrderTravel(TreeNode root) {
        if (root == null) return null;
        Deque<TreeNode> deque = new LinkedList<>();
        List<List<Integer>> res = new LinkedList();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            //每一层的元素链的长度
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                //每次把上层元素poll的过程中，还要押入下层所有元素的元素，押入的顺序也是先left后right
                TreeNode node = deque.poll();
                levelList.add(node.val);
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
            }
            res.add(levelList);
        }
        return res;
    }

    //Z字打印
    public List<List<Integer>> zigzagLevelOrderDeque(TreeNode root) {
        List<List<Integer>> sol = new ArrayList<>();
        zOrderTravel(root, sol, 0);
        return sol;
    }

    public static void zOrderTravel(TreeNode root, List<List<Integer>> sol, int level) {
        if (root == null) return;
        if (sol.size() <= level) {
            List<Integer> levelList = new ArrayList<>();
            sol.add(level, levelList);
        }
        List<Integer> levelList = sol.get(level);
        if (level % 2 == 0) levelList.add(root.val);
        else levelList.add(0, root.val);
        zOrderTravel(root.right, sol, level + 1);
        zOrderTravel(root.left, sol, level + 1);
//        Deque<TreeNode> deque = new LinkedList<>();
    }

    public List<List<Integer>> zigzagLevelOrderStack(TreeNode root) {
        TreeNode c = root;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (c == null) return ans;
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        s1.push(root);
        while (!s1.isEmpty()) {
            List<Integer> tmp = new ArrayList<Integer>();
            while (!s1.isEmpty()) {
                c = s1.pop();
                tmp.add(c.val);
                if (c.left != null) s2.push(c.left);
                if (c.right != null) s2.push(c.right);
            }
            ans.add(tmp);
            tmp = new ArrayList<Integer>();
            while (!s2.isEmpty()) {
                c = s2.pop();
                tmp.add(c.val);
                if (c.right != null) s1.push(c.right);
                if (c.left != null) s1.push(c.left);
            }
            if (!tmp.isEmpty()) ans.add(tmp);
        }
        return ans;
    }

    public static void midOrderTravel(TreeNode root) {
        if (root == null) return;

        Deque<TreeNode> deque = new java.util.LinkedList<>();
//        while (!deque.isEmpty() || root != null) {
//            //直接遍历到底，找到最左，但是一直在存节点
//            while (root != null) {
//                deque.push(root);
//                root = root.left;
//            }
//            //到了root == null了，该打印了吧
//            root = deque.pop();
//            System.out.print(root.val + "_");
//            root = root.right;
//        }
        while (!deque.isEmpty() || root != null) {
            //直接遍历到底，找到最左，但是一直在存节点
            if (root != null) {
                deque.push(root);
                root = root.left;
            } else {
                //到了root == null了，该打印了吧
                root = deque.pop();
                System.out.print(root.val + "_");
                root = root.right;
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("-----");
        midOrderTravel(root);
    }


    public static void preOrderTravel(TreeNode root) {
        if (root == null) return;

        Deque<TreeNode> deque = new java.util.LinkedList<>();
        deque.push(root);
        while (!deque.isEmpty()) {
            TreeNode pop = deque.pop();
            System.out.print(pop.val + "_");
            if (pop.right != null) {
                deque.push(pop.right);
            }
            if (pop.left != null) {
                deque.push(pop.left);
            }
        }
    }

    //left - right - mid
    //mid - right - left
    public static void postOrderTravel(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> deque = new java.util.LinkedList<>();
        Deque<TreeNode> help = new java.util.LinkedList<>();
        deque.push(root);
        while (!deque.isEmpty()) {
            TreeNode pop = deque.pop();
            help.push(pop);
            if (pop.left != null) {
                deque.push(pop.left);
            }
            if (pop.right != null) {
                deque.push(pop.right);
            }
        }
        while (!help.isEmpty()) {
            TreeNode pop = help.pop();
            System.out.print(pop.val + "_");
        }
    }


    static class TreeNode {
        TreeNode left;// 左节点(儿子)
        TreeNode right;// 右节点(儿子)
        Integer val;// 数据

        TreeNode(Integer val) {
            this.val = val;
        }
    }

    static TreeNode root = new TreeNode(1);

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
