package DataStructure.LinkedList;

import java.util.LinkedList;
import java.util.List;

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
        head = a;
    }


    public ListNode deleteNode(ListNode node) {

        return deleteNodeRecur(head, node);
    }


    public ListNode deleteNodeRecur(ListNode head, ListNode target) {

        //没有找到，就没有找到
        if (head == null) return null;
        //如果这轮递归找到就返回下下一个
        if (target.value.equals(head.value)) return head.next;
        head.next = deleteNodeRecur(head.next, target);
        //如果这轮递归没有找到，就返回本来head，并且上弹
        //最后回弹到最外层的还是第一个head
        return head;
    }


    //连标什么时候加一个dumy 节点
    // 1.可能第一个节点就被删除
    /*pre指向双指针*/

    public boolean deleteNodeLoop(ListNode head, Integer target) {


        ListNode dumy = new ListNode(0);
        dumy.next = head;
        //point1 ：prev point2 ： cur
        ListNode prev = dumy;
        ListNode cur = head;

        while (cur != null) {
            if(cur.value.equals(target)){
                prev.next = cur.next;
                return true;
            }
            prev = cur;
            cur = cur.next;
        }
        return false;
    }

    public ListNode deleteAllNode(ListNode head, int value) {
        //虚拟节点在开头
        ListNode help = new ListNode(0);
        help.next = head;
        ListNode cur = help;
//        a->b->c->d->e->f
        while (cur.next != null) {
            if (cur.next.value == value) {
                cur.next = cur.next.next;
            } else {
                //todo 错误！防止连续两次相等
                cur = cur.next;
            }
        }
        return help.next;
    }


    public static void main(String[] args) {
        DeleteNode deleteNode = new DeleteNode();
        System.out.println(deleteNode.deleteNode(new ListNode('a')));
        System.out.println(deleteNode.deleteAllNode(deleteNode.head, 'a').value);
    }
}