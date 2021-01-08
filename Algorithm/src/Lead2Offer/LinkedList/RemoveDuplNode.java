package Lead2Offer.LinkedList;

public class RemoveDuplNode {
    //单链表
    //相同的重复元素
    //去重复 要求：不要开空间，去重复结果稳定的
    //请问出了选择排序，还有最优的吗？
    public static Node solution(Node head) {
        if (head == null || head.next == null) return head;
        Node cur1 = head;
        Node cur2 = null;
        Node prev = null;
        while (cur1 != null) {
            prev = cur1;
            cur2 = cur1.next;
            while (cur2 != null) {
                if (cur2.val != cur1.val) {
                    prev = prev.next;
                } else {
                    prev.next = cur2.next;
                }
                cur2 = cur2.next;
            }
            cur1 = cur1.next;
        }
        return head;
    }

    /**
     * 有序链表
     * @param pHead
     * @return
     */
    public Node deleteDuplication(Node pHead){
        if(pHead == null || pHead.next == null)return pHead;
        Node dumy = new Node(0);
        dumy.next = pHead;
        Node pre = dumy;
        Node cur = dumy.next;
        while(cur != null){
            if(cur.next != null && cur.val == cur.next.val){
                //找到所有重复的节点
                while (cur.next != null && cur.val == cur.next.val){
                    cur = cur.next;
                }
                pre.next = cur.next;
                cur = cur.next;
            }else {
                //如果没有重复，就只管移动pre，cur指针
                pre = pre.next;
                cur = cur.next;
            }
        }
        return dumy.next;
    }

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void print(Node head) {

        while (head != null) {
            System.out.print(head.val+"->");
            head = head.next;
        }
        System.out.println(" ");
        System.out.println("----");
    }

    public static void main(String[] args) {
        Node head = new Node(4,
                new Node(2,
                        new Node(1,
                                new Node(3,
                                        new Node(1,new Node(3,
                                                new Node(4,new Node(5,new Node(4, null)))))))));
        print(head);
        solution(head);
        print(head);

    }

}
