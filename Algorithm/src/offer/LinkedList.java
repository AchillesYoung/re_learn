package offer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LinkedList {

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = head;
        ListNode cur = head.next;
        Set<Integer> set = new HashSet();
        set.add(head.val);
        while (cur != null) {
            if (!set.add(cur.val)) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public ListNode removeNode(ListNode head, int val) {
        if (head == null) return null;
        ListNode dumy = new ListNode(0);
        dumy.next = head;
        ListNode prev = dumy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
                break;
            } else {
                prev = cur;
            }
            cur.next = cur;
        }
        return dumy.next;
    }

    public ListNode deleteNodeRecur(ListNode head, int val) {
        if (head == null)
            return head;
        if (head.val == val)
            return head.next;
        head.next = deleteNodeRecur(head.next, val);
        return head;
    }


    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }

    public ListNode reverseRecur(ListNode head) {
        if (head == null || head.next == null) return head;
        return reverseRecur(head, null);
    }

    public ListNode reverseRecur(ListNode head, ListNode prev) {
        if (head == null) return prev;
        ListNode next = head.next;
        head.next = prev;
        return reverseRecur(next, head);
    }


    class ListNode {
        ListNode next;
        Integer val;

        public ListNode(Integer val) {
            this.val = val;
        }
    }

    static ListNode head;

    public static void main(String[] args) {
        System.out.println(null == null);
    }

}
