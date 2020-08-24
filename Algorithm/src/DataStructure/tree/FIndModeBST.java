package DataStructure.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * TODO
 *
 * @author yangshu
 * @version 5.0.0
 * @created at 2020/8/14-10:23 AM
 * copyright @2020 Beijing Morong Information Techology CO.,Ltd.
 */
public class FIndModeBST {

    private static List<Integer> items;
    private static TreeNode root;

    private static int maxCount;
    private static int curCount;
    static TreeNode prev = null;

    public static int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        items = new ArrayList<>();
        maxCount = 1;
        curCount = 1;

        midTraversal(root);
        if(curCount > maxCount)
            return new int[]{prev.val};
        if(curCount == maxCount)
            items.add(prev.val);

        //如果pre == null，说明这是遍历的第一个结点，不需要处理（第一个结点的初条件在主函数中设定）
        /**
         * 如果当前结点值与上一个结点值相等，那么这个数字的出现次数+1。
         *
         * 如果不想等：
         *  我们先去判断，上一个数字的出现次数curCount与之前的最大出现次数maxCount谁更大：
         *      如果上一个数字出现次数最大，需要更新众数信息。首先更新最大出现次数maxCount = curCount;。
         *          然后将之前记录的众数清空，再将上一个数字放入items.clear(); items.add(pre.val);
         *      如果一个数字出现次数等于最大出现次数，那么目前来看，它也是可能的众数，加入列表items.add(pre.val);
         *  否则，上一个数字一定不是众数，不管它，继续保留List中的数字。最后，重置计数curCount = 1;，表示当前数字出现一次了
         *
         */

        int[] res = new int[items.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = items.get(i);
        return res;
    }

    private static void midTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (prev != null) {
                if (!prev.val.equals(root.val)) {
                    //pre现在要停止重复++计数了，出现比之前次数更多，之前是maxCount记录
                    if (curCount > maxCount) {
                        //替换之前的maxCount，并且清掉list
                        maxCount = curCount;
                        items.clear();
                        //把之前的那个节点添加，并且重新计数
                        items.add(prev.val);

                    } else if (curCount == maxCount){
                        //相当
                        items.add(prev.val);
                    }
                    curCount = 1; // 当前值与上一个结点值不同，重置计数
                } else {
                    curCount++; // 当前值与上一个结点值相同，当前值的出现次数增加。
                }
            }
            prev = root;
            root = root.right;

        }
    }

    public static void main(String[] args) {
        int[] arr = new int[5];
        arr = findMode(root);
        System.out.println(Arrays.toString(arr));
    }


    static {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = null;
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(2);
//        TreeNode treeNode5 = new TreeNode(2);


        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        root = treeNode1;

//        treeNode2.right = treeNode5;


//        TreeNode treeNode6 = new TreeNode(4);
//        TreeNode treeNode7 = new TreeNode(1);
//        treeNode6.left = treeNode7;


    }

}
