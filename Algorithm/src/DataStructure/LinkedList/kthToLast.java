package DataStructure.LinkedList;

/**
 * TODO
 *
 * @author yangshu
 * @version 5.0.0
 * @created at 2020/5/21-2:31 PM
 * copyright @2020 Beijing Morong Information Techology CO.,Ltd.
 */
public class kthToLast {

    static ListNode head;

   static  {
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
        head=a;
    }

    public static int kthToLast(ListNode head, int k) {

        ListNode point1 = head;
        ListNode point2 = head;
        //1-2-3-4-5-6   k=2
        while (point1.next!=null){
            if(k>0) {
                point1=point1.next;
            }else
            {
                point2=point2.next;
                point1=point1.next;
            }

            k--;
        }

        return point2.next.value;
    }
    public static int kthToLast2(ListNode head, int k) {

            ListNode fast = head;
            ListNode slow = head;
            while (fast != null) {
                fast = fast.next;
                if(k<=0){
                    //1
                    slow = slow.next;
                }
                k--;
            }
            return slow.value;
        }

    public static void main(String[] args) {

        System.out.println((char)kthToLast(head,1));
    }
}
