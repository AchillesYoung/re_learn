package DataStructure.LinkedList;

import com.sun.org.apache.bcel.internal.generic.RET;

public class RecursiveReverse {


    public static ListNode recursiveReverse(ListNode head){
        //cant check in while(ListNode!=null),
        //only can be checked by ListNode.next!-=null
        //1->2->3->4
        if(head== null || head.next == null){
            return head;
        }
        // 1.next = temp = 2
        ListNode temp = head.next;
        System.out.println(temp);
        //recursiveReverse(2);---into recursive process 2.next = 3-->.....4.next = null return 4
        //newHead =4, temp =4 head =3  //head = 2 tmp =3// head=1 tmp=2
        ListNode newHead = recursiveReverse(head.next);
        //4->3->2->1  || 3->4-->>>>>4->3->2->1
        temp.next = head;
        // head.next = null;
        head.next = null;
        return newHead; //4
    }
    public static void main(String[] args) {
//        ListNode head = new ListNode(1);
//        System.out.println(head);
//        SingleLinkedList list = new SingleLinkedList(head);
//        list.addNode(new ListNode(2));
//        list.addNode(new ListNode(3));
//        list.addNode(new ListNode(4));
//        list.addNode(new ListNode(5));
//        list.addNode(new ListNode(6));
////        System.out.println(head);
////        System.out.println(list.linkedListlength());
//        //list.traverse();
//        head = recursiveReverse(head.next);
//        list.setHead(head);
//        System.out.println(list.linkedListlength());
//        list.traverse();
    }


}
