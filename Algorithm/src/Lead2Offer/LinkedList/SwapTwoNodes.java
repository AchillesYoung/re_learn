package Lead2Offer.LinkedList;

/**
 * TODO
 *
 * @author yangshu
 * @version 5.0.0
 * @created at 2020/8/17-10:54 PM
 * copyright @2020 Beijing Morong Information Techology CO.,Ltd.
 */
public class SwapTwoNodes {

    public ListNode swapTwoNodes(ListNode node) {

        //这里头节点的null->head不用管,ListNode 如果前区指针的引用变了，那么前驱就是null
        if (node == null || node.next == null) {
            return null;
        }
        ListNode next = node.next;
        node.next = swapTwoNodes(node.next.next);
        next.next = node;
        return next;
    }

    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;
        while (temp.next != null && temp.next.next != null) {
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;

    }

    public static void main(String[] args) {
        ListNode next = new ListNode(0);
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        next.next = node;
        next.next = node1;
        System.out.println(next.next.val);
    }

}
