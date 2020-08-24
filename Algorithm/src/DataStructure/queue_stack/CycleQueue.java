package DataStructure.queue_stack;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 循环队列:目的是重用我们之前提到的被浪费的存储。
 * 循环必备是%size求余
 * 具体来说，我们可以使用
 * 1.固定大小的数组
 * 2.两个指针来指示起始位置和结束位置。
 */
public class CycleQueue {

    private int head;
    private int tail;
    private Integer[] arr;
    private int size;

    /**
     * 我开始的想法是初始化的head和tail都是0,先arr[tail]再tail++这样，remove的时候也就直接arr[head]=0，head++
     * 现在我们都从head=-1开始，因为索引是从0开始到4，4-（-1）=5才是真实的长度，要不然就是5-0
     **/
    public CycleQueue(int k) {
        arr = new Integer[k];
        head = 0;
        tail = 0;
        size = k;
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        if (head == tail) {
            return true;
        }
        return false;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
//        System.out.println((tail + 1) % size);
        return ((tail + 1) % size) == head;
    }

    /**
     * 先判断full和空，如果空了，
     * tail先求余数，余数可以循环
     * 比如tail=4，那么4+1%5=0其实就是从0开始了，
     **/
    public void enQueue(int value) {
        if (isFull() == false) {
            tail = (tail + 1) % size;
            this.arr[tail] = value;
            return;
        }
        System.out.println("ERROR:Queue is Full");
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty() == false) {
            head = (head + 1) % size;
            return true;
        }
        System.out.println("ERROR:Queue is Empty");
        return false;
    }

    public static void main(String[] args) {
        CycleQueue cycleQueue = new CycleQueue(5);
        System.out.println(cycleQueue.isEmpty());

        cycleQueue.enQueue(0);
        cycleQueue.enQueue(1);
        cycleQueue.enQueue(2);
        cycleQueue.enQueue(3);
        cycleQueue.enQueue(4);
        System.out.println(cycleQueue.isFull());
        cycleQueue.deQueue();
        System.out.println(cycleQueue.isFull());
        cycleQueue.deQueue();

    }

}
