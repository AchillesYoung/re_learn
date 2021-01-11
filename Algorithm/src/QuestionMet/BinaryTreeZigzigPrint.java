package QuestionMet;

import DataStructure.tree.TreeNode;

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
     * 双端队列
     */
    public List<List<Integer>> zigzagLevelOrderDeque(TreeNode root) {
        List<List<Integer>> sol = new ArrayList<>();
        //打印从第一层，0为偶数，1为奇数
        travel(root, sol, 0);
        return sol;
    }

    private void travel(TreeNode curr, List<List<Integer>> sol, int level) {
        if (curr == null) return;
        //如果size不小于等于，说明已经创建，那直接后面get拿，不然进去创建
        if (sol.size() <= level) {
            //来个新的，add进去二维
            List<Integer> newLevel = new LinkedList<>();
            sol.add(newLevel);
        }

        //拿到相应level的
        List<Integer> createdLevel = sol.get(level);
        //偶数从后边加，奇数从前边加
        if (level % 2 == 0) createdLevel.add(curr.val);
        else createdLevel.add(0, curr.val);

        //先拿左边，再拿右边，记得level+1
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
