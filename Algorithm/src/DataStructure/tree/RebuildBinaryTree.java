package DataStructure.tree;


import java.util.ArrayList;
import java.util.Queue;

/**
 * TODO
 */
public class RebuildBinaryTree {
    /**
     * recursive
     */

    public TreeNode rebuildBinaryTree(int[] pre, int[] in) {
        TreeNode root;
        root = rebuild(pre, 0, pre.length - 1, in, 0, in.length - 1);

        return root;
    }

    public TreeNode rebuild(int[] pre, int preLeft, int preRight, int[] mid, int midLeft, int midRight) {

        if (preLeft > preRight || midLeft > midRight) {
            //结束了，因为上个压栈调用的没有判断
            return null;
        }
        TreeNode root = new TreeNode(pre[preLeft]);

        //i 不是从0开始算，是从mid
        /**
         * 错误是i的判断
         * mid[]数组里面的i坐标没问题，但是换算到pre[]数组里面就容易出问题。要注意i-midLeft
         */
        for (int i = midLeft; i <=midRight; i++) {
            if (pre[preLeft] == mid[i]) {
                root.left = rebuild(pre, preLeft + 1, preLeft+i-midLeft, mid, midLeft, i - 1);
                root.right = rebuild(pre, preLeft+i-midLeft + 1, preRight, mid, i + 1, midRight);
            }

        }
        return root;
    }
}
