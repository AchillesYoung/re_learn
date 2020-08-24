package Lead2Offer.BinaryTree;

/**
 * 前序遍历序列的第一个元素 1 就是二叉树的根节点，中序遍历序列的根节点 1 把这个序列分成两半部分，
 * 分别是[4,7,2]和[5,3,8,6]，左半分部是根节点的左子树，右半分布是根节点的右子树。
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
