package DataStructure.LinkedList;

import java.util.LinkedList;

/**
 * 链表失去了数组随机读取的优点，同时链表由于增加了结点的指针域，空间开销比较大。
 * 由于不必须按顺序存储，
 * 链表在插入的时候可以达到O(1) 的复杂度，
 * 查找一个节点或者访问特定编号的节点则需要O(n) 的时间
 * 而顺序表相应的时间复杂度分别是 O(log n) 和 O(1)
 */
public class ListNode {
    Integer value;
    ListNode next;

    public ListNode(int x) {
        this.value = x;
    }
}

class DeleteNode {
     ListNode head;
     {
        ListNode a = new ListNode('a');
        ListNode b = new ListNode('b');
        ListNode c = new ListNode('c');
        ListNode d = new ListNode('a');
        ListNode e = new ListNode('e');
        ListNode f = new ListNode('f');

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        head=a;

    }

    public boolean deleteNode(ListNode node) {
         if(head.value.equals(node.value)){
             head = head.next;
             return true;
         }
//        a->b->c->d->e->f
        while (head.next!=null) {
            if (head.next.value.equals(node.value)){
                head.next = head.next.next;
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public ListNode deleteAllNode(ListNode head, int value) {
         //虚拟节点在开头
        ListNode help= new ListNode(0);
        help.next= head;
        ListNode cur=help;
//        a->b->c->d->e->f
        while (cur.next!=null) {
            if (cur.next.value == value) {
                cur.next = cur.next.next;
            }else {
                //todo 错误！防止连续两次相等
                cur = cur.next;
            }
        }
        return help.next;
    }


    public static void main(String[] args) {
        DeleteNode deleteNode = new DeleteNode();
        System.out.println(deleteNode.deleteNode(new ListNode('a')));
        System.out.println(deleteNode.deleteAllNode(deleteNode.head,'a').value);
    }
}