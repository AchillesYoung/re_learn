package Lead2Offer.LinkedList;

/**
 * TODO
 *
 * @author yangshu
 * @version 5.0.0
 * @created at 2020/8/18-11:45 PM
 * copyright @2020 Beijing Morong Information Techology CO.,Ltd.
 */
public class MergeTwoLists {

    public static ListNode merge(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode prev = head;
        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                prev.next = l2;
                l2 = l2.next;
            } else {
                prev.next = l1;
                l1 = l1.next;
            }
            prev = prev.next;
        }

        //之前有错误是因为，l节点没有传递，只传递了prev
        //prev = prev.next是错误的，因为l节点没有传递，造成了死循环
        prev.next = l1 == null ? l2 : l1;
        return head.next;
    }

    public static ListNode mergeRecur(ListNode l1, ListNode l2) {

        /**
         * 终止条件：当两个链表都为空时，表示我们对链表已合并完成。
         * 如何递归：我们判断 l1 和 l2 头结点哪个更小，然后较小结点的 next 指针指向其余结点的合并结果。（调用递归）
         */
       if(l1==null){
           return l2;
       }else if(l2==null){
           return l1;
       }else if(l1.val < l2.val){
           //去递归，因为l1小，所以把l1.next作为一个新的节点传递给下一个，然后l1去指向下层递归返回的结果链
           l1.next = mergeRecur(l1.next,l2);
           return l1;
       }else{
           l2.next = mergeRecur(l2.next,l2);
           return l2;
       }
    }



    static ListNode a = new ListNode(1);
    static ListNode aa = new ListNode(2);

    static {
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(5);
        ListNode d = new ListNode(7);

        ListNode bb = new ListNode(6);
        ListNode cc = new ListNode(7);
        ListNode dd = new ListNode(8);


        a.next = b;
        b.next = c;
        c.next = d;

        aa.next = bb;
        bb.next = cc;
        cc.next = dd;
    }

    public static void main(String[] args) {
        System.out.println(merge(a, aa).val);

    }

}
