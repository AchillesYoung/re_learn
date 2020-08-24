package DataStructure.tree;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

/**
 * 1.2. bst共同祖先 BSTCommonAncestor
 * 3. 第k个最小元素 kthSmallestBST
 * 4. 有序数组转为  sortedArrayToBST
 */
public class BinarySearchTree {


    /**
     * 找到BST中的目标节点
     */
    public TreeNode findNode(TreeNode root, int key) {

        /**
         * 刹车线，找到了，或者没有该节点
         */
        if (root == null || key == root.val) {
            return root;
        }
        if (key > root.val) {
            return findNode(root.right, key);
        } else {
            return findNode(root.left, key);
        }
    }

    Random rand = new Random();

    public TreeNode sortedArrayToBST(int[] nums) {
        return recurHelper(nums, 0, nums.length - 1);
    }

    public TreeNode recurHelper(int[] arr, int left, int right) {
        //递归刹车条件
        if (left > right) {
            return null;
        }
        /**
         * 直观地看，我们可以选择中间数字作为BST的根节点，这样分给左右子树的数字个数相同或只相差1，使树保持平衡。
         * 不管数组长度奇偶，选择其中两个任意一个中间位置数字作为根节点，
         * 则根节点的下标为rand.nextInt(2), 两者中随机选择一个。
         */
        int mid = left + (right - left + rand.nextInt(2)) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        //类似归并的，二分数组
        root.right = recurHelper(arr, mid + 1, right);
        root.left = recurHelper(arr, left, mid - 1);
        return root;
    }

    class BSTIterator {

        //bst转成中序列数组
        ArrayList<Integer> nodesSorted;

        Stack<TreeNode> stack = new Stack<>();
        int index;//追针

        public BSTIterator(TreeNode root) {
            // Stack for the recursion simulation
            this.stack =  new Stack<TreeNode>();
            // Pointer to the next smallest element in the BST
            this.leftMostInorder(root);
        }

        public void leftMostInorder(TreeNode root){
            // For a given node, add all the elements in the leftmost branch of the tree to the stack.
            while (root != null) {
                this.stack.push(root);
                root = root.left;
            }

        }

        public int next() {
            // Node at the top of the stack is the next smallest element
            TreeNode topmostNode = this.stack.pop();

            // Need to maintain the invariant. If the node has a right child, call the
            // leftMostInorder function for the right child
            if (topmostNode.right != null) {
                this.leftMostInorder(topmostNode.right);
            }
            return topmostNode.val;
        }

        /**
         * check stack size to confirm whether we have a next smallest number
         */

        public boolean hasNext() {
            return this.stack.size() > 0;
        }
    }
}
