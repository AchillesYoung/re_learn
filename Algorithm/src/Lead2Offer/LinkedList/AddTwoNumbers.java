package Lead2Offer.LinkedList;

/**
 * TODO
 *
 * @author yangshu
 * @version 5.0.0
 * @created at 2020/8/16-11:35 PM
 * copyright @2020 Beijing Morong Information Techology CO.,Ltd.
 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1.next.next.val == 0){
            return l2;
        }
        if(l2.next.next.val == 0){
            return l1;
        }
        ListNode res = new ListNode(l1.val+l2.val);
        ListNode tmpNode = res;
        int tmp = (l1.val+l2.val) > 10 ? 1:0;
        for(int i =0; i<2;i++){
            l1 = l1.next;
            l2 = l2.next;
            int sum = l1.val+l2.val;
            tmpNode.next = new ListNode(sum%10+tmp);
            if(sum >=10){
                tmp = 1;
            }else{
                tmp = 0;
            }
            tmpNode = tmpNode.next;

        }

        return res;
    }

    /**
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbersMy(ListNode l1, ListNode l2) {
        int carry = 0;
        int tmpSum = 0;
        ListNode dumy = new ListNode();
        ListNode cur = dumy;
        while(l1 !=null || l2 !=null ){
            int l2val = l2 != null ? l2.val : 0;
            int l1val = l1 != null ? l1.val : 0;
            tmpSum = l1val + l2val +carry;
            //忘记取mod
            cur.next = new ListNode(tmpSum%10);
            carry = tmpSum/10;
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) {
//            System.out.println(carry);
            cur.next = new ListNode(carry);
        }
        return dumy.next;
    }

    public static ListNode addTwoNumber(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
//            System.out.println(carry);
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    static ListNode a = new ListNode(1);
    static ListNode aa = new ListNode(4);

    static {
//        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);

//        ListNode aa = new ListNode(4);
        ListNode bb = new ListNode(5);
        ListNode cc = new ListNode(8);

        a.next = b;
        b.next = c;

        aa.next = bb;
        bb.next = cc;
    }

    public static void main(String[] args) {

//        System.out.println(5%2);
//        System.out.println(16%10);

        System.out.println(13/10);
        System.out.println(addTwoNumber(a, aa).val);
        System.out.println(addTwoNumber(a, aa).next.val);
        System.out.println(addTwoNumber(a, aa).next.next.val);
        System.out.println(addTwoNumber(a, aa).next.next.next.val);
    }



}
