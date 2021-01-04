package QuestionMet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LinkedList {

    //删除元素
    public ListNode removeNodes(ListNode head, int target) {

        if(head == null){
            return null;
        }
        ListNode dumy = new ListNode();
        dumy.next = head;
        ListNode prev = dumy;
        ListNode cur = head;
        while (cur != null){
            if(cur.val == target){
                prev.next = cur.next;
            }else {
                prev = prev.next;
            }
            cur = cur.next;
        }
        return dumy.next;
    }

        //倒数第n
    public ListNode removeDuplicateNodes(ListNode head) {

        if(head == null){
            return null;
        }
        //单链表去重
        Set<Integer> set = new HashSet<>();
        ListNode prev = null;
        ListNode cur =  head;
        while (cur != null){
            if(!set.add(cur.val)){
                prev.next = cur.next;
            }else {
                prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    class ListNode{
        ListNode next;
        int val;
    }

    public static void main(String[] args) {

    }

}
