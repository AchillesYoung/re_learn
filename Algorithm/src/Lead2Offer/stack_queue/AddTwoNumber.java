package Lead2Offer.stack_queue;

import Lead2Offer.LinkedList.ListNode;
import javafx.beans.binding.When;

import java.util.Stack;

/**
 * TODO
 *
 * @author yangshu
 * @version 5.0.0
 * @created at 2020/8/17-11:07 AM
 * copyright @2020 Beijing Morong Information Techology CO.,Ltd.
 */
public class AddTwoNumber {

    public static ListNode addTwoNumber(ListNode l1, ListNode l2) {
        //先把两个list都压到stack里面
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode p = null;
        ListNode q = null;
        ListNode res = null;
        ListNode zero = new ListNode(0);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {

            if (!stack1.isEmpty())
            {p = stack1.pop();}
            else {
                p = zero;
            }
            if (!stack2.isEmpty()) q = stack2.pop();
            else q = zero;
            int sum = p.val + q.val + carry;

            carry = sum/10;
//            System.out.println(carry);
            sum = sum%10;
//            System.out.println(sum);
            ListNode node = new ListNode(sum);
            node.next = res;
            res = node;
            System.out.println("----");
        }

        if(carry == 1){
            ListNode node = new ListNode(1);
            node.next = res;
            res = node;
        }
        return res;

    }
    static ListNode a = new ListNode(7);
    static ListNode aa = new ListNode(5);

    static {
//        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(3);
        //(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
        //7 -> 8 -> 0 -> 7
//        ListNode aa = new ListNode(4);
        ListNode bb = new ListNode(6);
        ListNode cc = new ListNode(4);

        a.next = b;
        b.next = c;
        c.next = d;

        aa.next = bb;
        bb.next = cc;
    }

    public static void main(String[] args) {

//        System.out.println(5%2);
//        System.out.println(16%10);

        System.out.println(addTwoNumber(a, aa).val);
        System.out.println(addTwoNumber(a, aa).next.val);
        System.out.println(addTwoNumber(a, aa).next.next.val);
        System.out.println(addTwoNumber(a, aa).next.next.next.val);
    }


}
