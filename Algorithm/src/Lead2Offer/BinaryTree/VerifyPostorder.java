package Lead2Offer.BinaryTree;

import java.util.Deque;

/**
 *输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 *
 * 后序遍历的顺序是left->right->root
 * 单调栈
 * stack<int> st;
 * //此处一般需要给数组最后添加结束标志符，具体下面例题会有详细讲解
 * for (遍历这个数组)
 * {
 * 	if (栈空 || 栈顶元素大于等于当前比较元素)
 *        {
 * 		入栈;
 *    }
 * 	else
 *    {
 * 		while (栈不为空 && 栈顶元素小于当前元素)
 *        {
 * 			栈顶元素出栈;
 * 			更新结果;
 *        }
 * 		当前数据入栈;
 *    }
 * }
 */
public class VerifyPostorder {

    public boolean verifyPostOrder(int[] postorder) {

        return false;
    }
}
