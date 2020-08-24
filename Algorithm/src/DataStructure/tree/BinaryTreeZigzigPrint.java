package DataStructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * TODO
 *
 * @author yangshu
 * @version 5.0.0
 * @created at 2020/8/5-11:27 AM
 * copyright @2020 Beijing Morong Information Techology CO.,Ltd.
 */
public class BinaryTreeZigzigPrint {

    /**
     * 两个stack
     */
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

    /**
     * 双端队列
     */
    public List<List<Integer>> zigzagLevelOrderDeque(TreeNode root) {
        List<List<Integer>> sol = new ArrayList<>();
        travel(root, sol, 0);
        return sol;
    }

    private void travel(TreeNode curr, List<List<Integer>> sol, int level) {
        if (curr == null) return;

        if (sol.size() <= level) {
            List<Integer> newLevel = new LinkedList<>();
            sol.add(newLevel);
        }

        List<Integer> collection = sol.get(level);
        if (level % 2 == 0) collection.add(curr.val);
        else collection.add(0, curr.val);

        travel(curr.left, sol, level + 1);
        travel(curr.right, sol, level + 1);
    }

    /**
     * 一个stack的错误解法，在for循环里，stack会混乱，for循环的本意是循环出来这一层所有的
     * 但是stack是先进先出,会出现混乱
     * stack里这一层的还没清空，下一层的就进来了，打乱了stack.pop的顺序，
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrderError(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        int level = 0;
        while (!stack.isEmpty()) {
            int count = stack.size();
            List<Integer> list = new ArrayList<>();
            level++;
            for (; count > 0; --count) {
                root = stack.pop();
                list.add(root.val);
                if (level % 2 == 1) {
                    if (root.left != null) {
                        stack.push(root.left);
                    }
                    if (root.right != null) {
                        stack.push(root.right);
                    }
                } else {
                    if (root.right != null) {
                        stack.push(root.left);
                    }
                    if (root.left != null) {
                        stack.push(root.left);
                    }
                }
            }
            res.add(list);
        }
        return res;
    }

}
