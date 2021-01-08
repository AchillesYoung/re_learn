package Lead2Offer.stack_queue;

public class CycleQueue {

    private int[] queue;
    private int headIndex;
    private int capacity;
    //队列长度
    private int count;

    public CycleQueue(int k) {
        //数组长度
        this.capacity = k;
        this.queue = new int[k];
        this.headIndex = 0;
        //牛逼这里省了一个尾巴节点
        //尾巴长度类似this.headIndex + this.count
        //现在队列长度
        this.count = 0;
    }

    public boolean isEmpty() {
        return (this.count == 0);
    }

    public boolean isFull() {
        return (this.count == this.capacity);
    }

    public boolean enQueue(int value) {
        if (isFull())
            return false;
        //返回尾巴长度，count继续当尾巴
        this.queue[(this.headIndex + this.count) % this.capacity] = value;
        this.count += 1;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty())
            return false;
        //这里取模，是因为当headIndex为5的时候，+1可以mod到0
        this.headIndex = (this.headIndex + 1) % this.capacity;
        this.count -= 1;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (this.count == 0)
            return -1;
        return this.queue[this.headIndex];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (this.count == 0)
            return -1;
        int tailIndex = (this.headIndex + this.count - 1) % this.capacity;
        return this.queue[tailIndex];

    }


}
