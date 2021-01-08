package Lead2Offer.stack_queue;

public class CycleQueue {

    private int[] queue;
    private int headIndex;
    private int capacity;
    //���г���
    private int count;

    public CycleQueue(int k) {
        //���鳤��
        this.capacity = k;
        this.queue = new int[k];
        this.headIndex = 0;
        //ţ������ʡ��һ��β�ͽڵ�
        //β�ͳ�������this.headIndex + this.count
        //���ڶ��г���
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
        //����β�ͳ��ȣ�count������β��
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
        //����ȡģ������Ϊ��headIndexΪ5��ʱ��+1����mod��0
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
