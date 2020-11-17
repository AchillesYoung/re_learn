package Lead2Offer.LinkedList;

/**
 * TODO
 */
public class RotateKthRight {

    public ListNode rotateRight(ListNode head, int k) {
        // base cases
        if (head == null) return null;
        if (head.next == null) return head;
        //计算 队列长度用去mod
        ListNode old_tail = head;
        int n;
        // 0,1,2,3 长度是4 如果n=0开始，head指针移动3下到3，0+3长度不够，n需要从1开始
        for (n = 1; old_tail.next != null; n++)
            old_tail = old_tail.next;
        // close the linked list into the ring
        old_tail.next = head;
        //这里长度是n mod, k可以被写成 k = (k // n) * n + k % n
        // find new tail : (n - k % n - 1)th node
        ListNode new_tail = head;
        for (int i = 0; i < n - k % n - 1; i++)
            new_tail = new_tail.next;
        // new head : (n - k % n)th node
        ListNode new_head = new_tail.next;
        // break the ring
        new_tail.next = null;

        return new_head;
    }

}
