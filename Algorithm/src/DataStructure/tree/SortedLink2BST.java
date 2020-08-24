package DataStructure.tree;

import DataStructure.LinkedList.ListNode;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author yangshu
 * @version 5.0.0
 * @created at 2020/7/15-11:46 AM
 * copyright @2020 Beijing Morong Information Techology CO.,Ltd.
 */
public class SortedLink2BST {

    public class ListNode {
        Integer value;
        ListNode next;

        public ListNode(Integer value, ListNode next) {
            this.value = value;
            this.next = next;
        }
        public ListNode(int x) {
            this.value = x;
        }
    }

    public TreeNode sortedLink2BST(ListNode head){

        // If the head doesn't exist, then the linked list is empty
        if (head == null) {
            return null;
        }
        ListNode mid = findMidElement(head);
        TreeNode root = new TreeNode(mid.value);
        // Base case when there is just one element in the linked list
        //没有这个如果只有一个元素会root.left=root死循环，所以这个递归有两个出口
        if (head == mid) {
            return root;
        }
        root.left = sortedLink2BST(head);
        root.right = sortedLink2BST(mid.next);
        return root;
    }

    public ListNode findMidElement(ListNode head){
        ListNode prev = null;
        ListNode fast = head;
        ListNode slow =head;
        // Iterate until fastPr doesn't reach the end of the linked list.
        /**
        错误思想，这里while判断条件不够。
         出现了，如果长度是3的链表slow会是最后一个节点，因为f1.next已经是空了
         而且就算不是3，当长度是偶数的时候，slow找到的都是两个mid的后一个(这个可接受
        while (fast !=null){
            fast = fast.next.next;
            slow = slow.next;
        }
         而且这里不只是要找到中间节点还要保留中间节点的前一个
         **/

        while (fast !=null || fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        /**
         1.Handling first case when only one node on linkedlist.
         2. Handling 左半部分list的重点是null
          */
        if (prev != null) {
            prev.next = null;
        }
        return slow;
    }

}
