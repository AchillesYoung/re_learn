package Lead2Offer.LinkedList;

/**
 * TODO
 *
 * @author yangshu
 * @version 5.0.0
 * @created at 2020/8/18-12:08 AM
 * copyright @2020 Beijing Morong Information Techology CO.,Ltd.
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        return reverseList(head, null);
    }

    public ListNode reverseList(ListNode cur, ListNode prev) {

        if (cur == null) {
            return prev;
        }
        ListNode next = cur.next;
        cur.next = prev;
        //这边和循环不一样的是不用关心pre->cur这个指针，因为上一个递归已经把prev指向prev.prev
        //所以到该循环位置，prev.next已经反向指好；
        return reverseList(next, cur);
    }

    public ListNode reverseListIter(ListNode head) {

        ListNode pre = null;

        while (head != null) {

            ListNode next = head.next;
            //每个循环我们只关注2个节点，cur和pre，我们反向一个指针，就是pre->cur改成pre<-cur
            // 接着我们记住pre，然后cur变成下一个，以此遍历直到 cur==null,pre是最后一个节点
            head.next = pre;
          //这里
//            next.next = head;
            pre = head;
            head = next;
        }
        //这里return pre是因为head ==null的时候，prev刚好是最后一个节点

        return pre;
    }
}
