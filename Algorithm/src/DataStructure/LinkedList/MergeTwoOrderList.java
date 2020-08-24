package DataStructure.LinkedList;

/**
 */
public class MergeTwoOrderList {
    static ListNode l1;
    static ListNode l2;

    static {
        ListNode a = new ListNode(-9);
        ListNode b = new ListNode(3);
        b.next=null;
//        ListNode c = new ListNode(6);
        ListNode d = new ListNode(5);
        ListNode e = new ListNode(7);
//        ListNode f = new ListNode(7);
        e.next=null;

        a.next = b;
//        b.next = c;
        d.next = e;
//        e.next = f;

        l1 = a;
        l2 = d;
    }

    public static ListNode solution(ListNode l1, ListNode l2) {
        ListNode tmpHead = new ListNode(0);
        ListNode cur = tmpHead;

        while (l1 != null && l2 != null) {
//            -9
            //3
            if(l1.value <= l2.value){
                cur.next = l1;
                //0--9 cur =0
                //0--9-3 cur =9
                l1=l1.next;
//                l1-3
            }else {
                cur.next = l2;
                l2=l2.next;
            }

//            cur =9
            //cur =3
            cur = cur.next;

        }
        while (l1 != null){
            cur.next = l1;
            l1=l1.next;
            cur =cur.next;
        }

        while (l2 != null){
            cur.next = l2;
            l2=l2.next;
            cur =cur.next;
        }
        return tmpHead.next;
    }

    public static void traverse(ListNode head) {
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

    public static void main(String[] args) {
        traverse(l1);
        traverse(l2);

        traverse(solution(l1,l2));

    }

}
