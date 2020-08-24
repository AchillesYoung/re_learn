package DataStructure.tree;

/**
 * TODO
 *
 * @author yangshu
 * @version 5.0.0
 * @created at 2020/8/15-10:32 PM
 * copyright @2020 Beijing Morong Information Techology CO.,Ltd.
 */
public class InsertNodeBst {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {

            return new TreeNode(val);
        }

        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);

        }
        //如果没有刹车，就返回root，root的两个子节点继续迭代
        return root;
    }

    public TreeNode insertIntoBST2(TreeNode root, int val) {
        //因为没有递归栈，所以这边要多一个引用指向节点
        TreeNode node = root;
        //while里面的是刹车条件
        while (node != null) {
            // insert into the right subtree
            if (val > node.val) {
                // 结果node.right==null这时候就该插入并且结束返回了
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    return root;
                    //else不该插入，继续循环
                } else node = node.right;
            }
            // insert into the left subtree
            else {
                // insert right now
                if (node.left == null) {
                    node.left = new TreeNode(val);
                    return root;
                } else node = node.left;
            }
        }
        return new TreeNode(val);
    }


}
