package DataStructure.tree;

import java.util.*;

/**
 */
public class BinaryTreePrint {
    private static TreeNode root;


    /**
     * 分而治之，先找最左子树的高度，root.left&&root.right==null;
     */
    public static int minDepth(TreeNode root) {
        //如root本身就null,层数是0,防止，root节点只有一个子节点
        if (root == null) {
            return 0;
        }
        //如果root的子树都为空，层数就是1
        /**
         * 最左子树层数是1，开始回调
         */
        if ((root.left == null) && (root.right == null)) {
            return 1;
        }
        //这个只是为了筛选出来三目里面最小的，取最大Integer
        int min_depth = Integer.MAX_VALUE;

        if (root.left != null) {
            min_depth = Math.min(minDepth(root.left), min_depth);
        }

        if (root.right != null) {
            min_depth = Math.min(minDepth(root.right), min_depth);
        }
        return min_depth + 1;
    }


    /**
     * 分而治之，先找最左子树的高度，root.left&&root.right==null;
     */
    public static int minDepth2(TreeNode root) {
        //如root本身就null,层数是0,防止，root节点只有一个子节点
        if (root == null) {
            return 0;
        } else {
            int left_depth = minDepth(root.left);
            int right_depth = minDepth(root.right);
            return Math.min(left_depth, right_depth) + 1;
        }
    }


    public static int maxDept(TreeNode root) {
        //如root本身就null,层数是0,防止，root节点只有一个子节点
        if (root == null) {
            return 0;
        } else {
            int max_dept = Integer.MIN_VALUE;
            max_dept = Math.max(maxDept(root.left), max_dept);
            max_dept = Math.max(maxDept(root.right), max_dept);

            return max_dept + 1;
        }


    }


    /**
     * level print 层次遍历基本
     */
    public static void bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            System.out.println(root.val);
            if (root.left != null) {
                queue.offer(root.left);
            }
            if (root.right != null) {

                queue.offer(root.right);
            }
        }
    }

    /**
     * level print
     * 这里第一次我想要用多一个queue去记录全部压进去的长度
     * 最优解是，每次循环开始while第一步先看上一轮压进去的长度，这里来了一个count去计算
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        //模拟二维数组
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            //全部压进去以后看长度
            int n = queue.size();
            //每一层的元素链
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                //每次把上层元素poll的过程中，还要押入下层所有元素的元素，押入的顺序也是先left后right
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }


    /**
     * dept print 深度遍历
     */
    public static void dfsStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            //stack模拟递归的时候要和递归的想法反着来
            /**
             * 递归是 先左边(left),再(right)
             * deptOrderRecursive(root.left);
             * deptOrderRecursive(root.right);
             * stack是先push(right)后push(left)，才能先pop(left)，sout(left),
             * 因为是人为手动pop的，都要执行到底，不像递归，递归可以在某一步中断然后，执行到底再回弹结束才，继续执行下面
             */
            root = stack.pop();
            if (root == null) {
                continue;
            }
            System.out.println(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
    }

    static void dfsRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        dfsRecursive(root.left);
        dfsRecursive(root.right);
    }


    public static List<List<Integer>> dfsOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        //用来存放最终结果
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(0, root, res);
        return res;
    }

    static void dfs(int index, TreeNode root, List<List<Integer>> res) {
        //假设res是[ [1],[2,3] ]， index是2，就再插入一个空list放到res中,因为新的一层要多一个新的index
        if (res.size() - 1 < index) {
            res.add(new ArrayList<Integer>());
        }
        //将当前节点的值加入到res中，index代表当前层，假设index是2，节点值是99
        //res是[ [1],[2,3] [4] ]，加入后res就变为 [ [1],[2,3] [4,99] ]
        res.get(index).add(root.val);
        //递归的处理左子树，右子树，同时将层数index+1
        if (root.left != null) {
            dfs(index + 1, root.left, res);
        }
        if (root.right != null) {
            dfs(index + 1, root.right, res);
        }
    }

    public static void main(String[] args) {
//        dfsStack(root);
//        System.out.println("----");
//        printList(dfsOrder(root));
//        System.out.println(maxDept(root));
        System.out.println(23%2==0);
    }


    public static void printList(List<List<Integer>> res) {
        for (List<Integer> levelList : res) {
            System.out.println();
            System.out.print("[");
            for (Integer val : levelList) {
                System.out.print(val + " ");
            }
            System.out.print("]");
        }
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

