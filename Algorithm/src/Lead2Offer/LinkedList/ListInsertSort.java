package Lead2Offer.LinkedList;

/**
 * TODO
 *
 * @author yangshu
 * @version 5.0.0
 * @created at 2020/8/19-11:11 AM
 * copyright @2020 Beijing Morong Information Techology CO.,Ltd.
 */
public class ListInsertSort {

    /**
     * 链表的插入排序。
     * 分析：
     * 需要三个指针
     * dumpy是个哨兵指针->head
     * head0永远指向已经排序的最后一个指针
     * next/pre 用于遍历当前已排序列表
     *
     * @return
     */
    public ListNode insertSort(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode head0 = head;

        while (head0 != null && head0.next!=null) {
            if (head0.next.val >= head0.val){
                head0 = head0.next;
                continue;
            }

            //每次循环都要new一个新的pre指针->head然后去
            ListNode pre = dummy;
            //zhuyi 细节，pre
            if(pre.next.val<head0.next.val){
                pre = pre.next;
            }
            ListNode next = head0.next;
            head0.next = next.next;
            next.next = pre;
            pre.next = next;


        }
        return dummy.next;
    }
}
