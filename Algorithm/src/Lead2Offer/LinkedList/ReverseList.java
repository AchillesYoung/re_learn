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
        /**
         * iteratively,curr指针把前面和后面当作两个节点，递归解决
         **/
        if (head == null || head.next == null) {
            return head;
        }
        return reverseList(head, null);
    }

    public ListNode reverseList(ListNode head, ListNode prev) {
        if (head == null) {
            return prev;
        }
        //先想递归的场景和递归逻辑, head
        //场景 null<-0<-1 2->3->4->null 这里1是prev，head是2
        ListNode cur = head.next;
        //先把3给记住，然后再把2->1 null<-0<-1<-2 3->4->null
        head.next = prev;
        //继续把prev = 2和 head = 3放进去
        return reverseList(cur, head);
        //继续走递归流程
        /**
         * null<-0<-1<-2 3->4->null 这里2是prev，head是3
         *  先把4给记住，然后再把3->2 null<-0<-1<-2<-3 4->null
         *  继续把prev = 3和 head = 4放进去
         *  null<-0<-1<-2><-3 4->null 这里3是prev，head是4
         *  ....
         * 继续把prev = 4和 head = null放进去
         */


    }

    public ListNode reverseListIter(ListNode head) {

        ListNode prev = null;
        //每个循环我们只关注2个节点，cur和pre，我们反向一个指针，就是pre->cur改成pre<-cur
        // 接着我们记住pre，然后cur变成下一个，以此遍历直到 cur==null,pre是最后一个节点
        while(head != null){
            //先拿当前节点的下一个节点放在next
            ListNode next = head.next;
            // 把当前节点，指向prev，之前下节点已经放在next
            head.next = prev;
            //这时候开始模拟递归操作，当前节点给prev，next节点给head
            prev = head;
            head = next;
            //null<-1（cur) 2(tmp)->3
            //
        }
        return prev;
    }


    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

}
