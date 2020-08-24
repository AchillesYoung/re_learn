package Lead2Offer.LinkedList;

/**
 * TODO
 *
 * @author yangshu
 * @version 5.0.0
 * @created at 2020/6/11-11:35 AM
 * copyright @2020 Beijing Morong Information Techology CO.,Ltd.
 */
public class DeleteNode {


    static ListNode head = new ListNode(0);

    static {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        head = a;
    }


    public static ListNode solution(ListNode head, int target) {
        ListNode prev = null;
        ListNode cur = head;
        if (head.val == target) {
            return head.next;
        }

        while (cur != null) {

            if (cur.val == target) {
                prev.next = cur.next;
            }
//            要记录一下上一个节点
            prev = cur;
            cur = cur.next;
        }
        return head;
    }

    public static void traverse(ListNode head) {
        //临时节点，从首节点开始
        ListNode temp = head;
        while (temp != null) {
            System.out.println(":" + temp.val);
            //继续下一个
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        traverse(solution(head, 6));
    }


}
