package QuestionMet;

public class ReverseList {

    static class Node {
        Node next;
        Integer value;

        Node(Integer value) {
            this.value = value;
        }

        Node(Node next, Integer value) {
            this.next = next;
            this.value = value;
        }
    }

    public static Node solution(Node head) {
        if (head == null) return head;
        Node prev = null;
        while (head != null) {
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static Node recur(Node head) {
        if (head == null) return head;
        return recur(null, head);
    }

    public static Node recur(Node prev, Node head) {
        if (head == null) return prev;
        Node next = head.next;
        head.next = prev;
        return recur(head, next);
    }

}
