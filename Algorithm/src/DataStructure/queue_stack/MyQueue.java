package DataStructure.queue_stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 队列是典型的 FIFO 数据结构。
 * 插入（insert）操作也称作入队（enqueue），新元素始终被添加在队列的末尾。
 * 删除（delete）操作也被称为出队（dequeue)。 你只能移除第一个元素。
 */

/**
 * MyQueue 用arraylist实现有问题就是
 * remove的操作，head一直++,arrayList底层要一直扩容，而且前面remove的空间会浪费
 * 这个实现需要优化，避免浪费空间，
 * 我们用一个定长最大长度为 5的数组实现，我们的解决方案很有效。
 * 例如，如果我们只调用入队函数四次后还想要将元素 10 入队，那么我们可以成功。
 * 但是我们不能接受更多的入队请求，这是合理的，因为现在队列已经满了。但是如果我们将一个元素出队呢
 */
public class MyQueue {
    //这里我用arraylist实现
    private List<Integer> myQueue;

    private int head;

    public MyQueue(){
        myQueue = new ArrayList<>();
        head=0;
    }
    //add
    public void add(Integer newElement){
        //添加head不变，删除
        myQueue.add(newElement);
        return;
    }
    //remove
    public boolean remove(){

        if(isEmpty()==true){
            return false;
        }
        //删除直接把head右边移动
        head++;
        return true;

    }
    public boolean isEmpty(){
        if(head>=myQueue.size()){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.add(1);
        myQueue.add(2);
        System.out.println(myQueue.myQueue.size());
        System.out.println(myQueue.remove());
        System.out.println(myQueue.remove());
        System.out.println(myQueue.isEmpty());
        System.out.println(myQueue.remove());
        /*
        Queue应该是链表实现比较容易LinkedList
         */
        Queue q = new LinkedList();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.poll();
    }
}
