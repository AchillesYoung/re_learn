package DataStructure.LinkedList;

import java.util.Stack;

/**
 * TODO
 *
 * @author yangshu
 * @version 5.0.0
 * @created at 2020/5/25-10:26 AM
 * copyright @2020 Beijing Morong Information Techology CO.,Ltd.
 */
public class ReverseList {
    static ListNode head;

    static {
        ListNode a = new ListNode('a');
        ListNode b = new ListNode('b');
        ListNode c = new ListNode('c');
        ListNode d = new ListNode('d');
        ListNode e = new ListNode('e');
        ListNode f = new ListNode('f');

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        head = a;
    }


    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;

        while (cur != null) {

            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;

//            cur = head.next.next;
//            head.next.next = head;
//            head=cur;
        }

        return pre;
    }

    public static void traverse4Reverse(ListNode head) {
        //临时节点，从首节点开始
        ListNode temp = head;
        while (temp != null) {
            if (temp.value != null) {
                System.out.println(":" + temp.value);
            }
            //继续下一个
            temp = temp.next;
        }
    }

    public static ListNode reverseListStack(ListNode head) {

        Stack<ListNode> stack = new Stack();

        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        head = stack.pop();
        ListNode cur = head;
        while (!stack.isEmpty()) {
            cur.next = stack.pop();
            if (stack.isEmpty()) {
                cur.next.next = null;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    /**
     * 避免循环，最后一个形成死循环97->98->97->98
     *
     * @param head
     * @return
     */
    public static ListNode reverseListNull(ListNode head) {

        Stack<ListNode> stack = new Stack();

        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        head = stack.pop();
        ListNode cur = head;
        while (!stack.isEmpty()) {
            cur.next = stack.pop();

            cur = cur.next;
            //最后把cur.next清null，避免死循环，因为链表的指针和stack不冲突
            cur.next=null;
        }

        return head;
    }

    public static void main(String[] args) {
        traverse4Reverse(head);
        System.out.println("-------");
        traverse4Reverse(reverseListNull(head));
    }
}
