package Lead2Offer.BinaryTree;

import java.util.LinkedList;

/**
 * 调用isSub()判断tree b的根节点在不在tree a的里，如果不在肯定，不是子树关系
 * 如果在，再调用recur(A, B)去判断是不是一样的树结构
 * 判断的左子节点是否相等，即 recur(A.left, B.left)
 * 判断的右子节点是否相等，即 recur(A.right, B.right)
 *
 * ...上面的思路没实现，最后还是用了暴力递归
 */
public class IsSubTree {


    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            //null的不算子树，因为已经递归到这null层了还不相等
            return false;
        }
        // 三个｜｜ 如果match了，就不会走 isSubStruct了，match失败就继续递归跟节点去判断isSub
        return match(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);

    }

    public static boolean match(TreeNode a, TreeNode b) {
        if (b == null) {
            //b == null, match 成功，不管a == null ｜｜ ！=null
            return true;
        }
        if (a == null) {
            //a == null, b!=null->false
            return false;
        }
        return (a.val == b.val) && match(a.left, b.left) && match(a.right, b.right);
    }

    public static void main(String[] args) {
        System.out.println(isSubStructure(root, subRoot));

    }


//    public boolean solution(TreeNode root, TreeNode subRoot) {
//
//        if(root==null||root==null){
//            return false;
//        }
//        boolean flag = false;
//        if(isSubTree(root,subRoot)!=null){
//            return recur(isSubTree(root,subRoot).left,subRoot.left) && recur(isSubTree(root,subRoot).right,subRoot.right);
//        }
//
//        return false;
//    }
//
//    public TreeNode isSubTree(TreeNode root, TreeNode subRoot) {
//
//        LinkedList<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            root = queue.pop();
//            if (root.val == subRoot.val) {
//                return root;
//            }
//            if (root.left != null) {
//                queue.offer(root.left);
//            }
//            if (root.right != null) {
//
//                queue.offer(root.right);
//            }
//        }
//        return null;
//    }
//
//    public boolean recur(TreeNode left, TreeNode subLeft) {
//
//        if(left.val==subLeft.val){
//
//        }else {
//
//        }
//
//
//        return false;
//    }

    static TreeNode root;
    static TreeNode subRoot;


    static {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(2);



        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;


        TreeNode treeNode6 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(1);
        treeNode6.left = treeNode7;


        root = treeNode1;
        subRoot = treeNode7;
    }

}
