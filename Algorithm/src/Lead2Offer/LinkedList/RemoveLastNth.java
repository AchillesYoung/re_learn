package Lead2Offer.LinkedList;


//一次通过的直观解答，当时没有考虑几个极端情况就通过。

/**
 * 复盘
 */

public class RemoveLastNth {



    public ListNode removeNthFromEnd(ListNode head, int n) {
        //case1: head == null
        if(head == null){
            return head;
        }
        //case 2: n大于listNode长度，或者到底也没有找到要删除的，会出现什么情况？在while条件里面解决掉了
        ListNode dumy = new ListNode();

        dumy.next = head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = dumy;

        while(fast != null){
            if(n > 0){
                fast = fast.next;
            }else{
                fast = fast.next;
                slow = slow.next;
                prev = prev.next;
            }
            n--;
        }
        prev.next = slow.next;
        return dumy.next;
    }
}
