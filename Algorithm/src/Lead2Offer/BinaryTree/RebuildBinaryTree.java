package Lead2Offer.BinaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author yangshu
 * @version 5.0.0
 * @created at 2020/6/11-12:30 PM
 * copyright @2020 Beijing Morong Information Techology CO.,Ltd.
 */
public class RebuildBinaryTree {


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        //普通解法存在的问题是每次都要循环inOrder数组去找root索引位置，这里可以优化O(n^2)到O(n)利用hashMap
        int length = preorder.length;
        for (int i = 0; i < length; i++) {
            //key是不重复的val值，value是midOrder的索引
            indexMap.put(inorder[i], i);
        }
        //每次递归都要传过去
        TreeNode root = buildTree(preorder, 0, length - 1, inorder, 0, length - 1, indexMap);
        return root;
    }


    public TreeNode buildTree(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight, Map<Integer, Integer> indexMap) {
        if (preLeft > preRight) {
            return null;
        }
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        if (preLeft == preRight) {
            return root;
        } else {
            int rootIndex = indexMap.get(rootVal);
            int leftLength = rootIndex - inLeft, rightLength = inRight - rootIndex;
            TreeNode leftSubtree = buildTree(preorder, preLeft + 1, preLeft + rootIndex - inLeft, inorder, inLeft, rootIndex - 1, indexMap);
            TreeNode rightSubtree = buildTree(preorder, preRight - rightLength + 1, preRight, inorder, rootIndex + 1, inRight, indexMap);
            root.left = leftSubtree;
            root.right = rightSubtree;
            return root;
        }
    }


    /**
     * recursive
     */

    public TreeNode rebuildBinaryTree(int[] pre, int[] in) {

        //利用特性，二分加查询，重建立
        /**
         * preorder mid -> left -> right
         * midorder left -> mid -> right
         **/

        //1.先找先序的第一个，去对应中序的某一个（应该是在中间）
        //2.然后inorder中的根节点去二分数组
        //inorder的索引（即左边长度为左子树木，构造了递归的条件）。
        //递归，重复step1，step2
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
            //0, 1，2，3，4，5，6
            //pre pre+1
            //i 不是从0开始算，是从mid
            /**
             * mid[]数组里面的i坐标没问题，但是换算到pre[]数组里面就容易出问题。记得考虑数组长度（索引差）不是索引
             *
             * 这里一个问题是每次都要循环inOrder数组去找root索引位置，这里可以优化O(n^2)到O(n)利用hashMap
             *
             */

            for (int i = midLeft; i <=midRight; i++) {
                //循环中找mid数组中的坐标(数组的长度是索引差+1），长度换算成索引要-1
                if (pre[preLeft] == mid[i]) {
                    //左子树
                    // 在pre数组中是从preLeft+1到preLeft+(i-midLeft),preLeft 是开始索引前一位置，加上数组长度(i-midLeft)是最后一位
                    // 在pre数组中是从midLeft到i-1(不包括i）因为i是根
                    root.left = rebuild(pre, preLeft + 1, preLeft+i-midLeft, mid, midLeft, i - 1);
                    //右边子树木
                    root.right = rebuild(pre, preLeft+i-midLeft + 1, preRight, mid, i + 1, midRight);
                }

            }
            return root;


        }
}
