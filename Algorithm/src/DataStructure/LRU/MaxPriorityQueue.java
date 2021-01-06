package DataStructure.LRU;

public class MaxPriorityQueue
        <Key extends Comparable<Key>>{

    // 存储元素的数组
    private Key[] pq;
    // 当前 Priority Queue 中的元素个数
    private int N = 0;

    public MaxPriorityQueue(int capacity) {
    // 索引 0 不用，所以多分配一个空间
        pq = (Key[]) new Comparable[capacity + 1];
    }
    //返回当前最大
    public Key max(){
        return pq[1];
    }
    // 插入元素 e到堆顶的最后，然后上浮到正确位置
    public void insert(Key e) {
        //插入到最后
        N++;
        pq[N] = e;
        // 然后让它上浮到正确的位置
        swim(N);
    }

    // 删除max并返回max
    public Key delMax() {
        //删除就是把 堆顶元素A和堆底最后元素b对换。删除A，然后让B下沉
        Key max = pq[1];
        //把这个最大元素换到最后，删除之
        exch(1, N);
        pq[N] = null;
        N--;
        // 让 pq[1] 下沉到正确位置 sink(1);
        return max;
    }

    /**
     * 如果某个节点 A 比它的父节点大，
     * 那么 A 不应该做子节点，应该把父 节点换下来，
     * 自己去做父节点，这就是对 A 的上浮。
     */
    private void swim(int k) {
        // 如果浮到堆顶，就不能再上浮了
        while (k>1 && less(parent(k),k)){
            // 如果第 k 个元素比上层大
            // 将 k 换上去
            exch(parent(k), k);
            k = parent(k);
        }
    }
    /**
     *
     1. 如果某个节点 A 比它的子节点(中的一个)小
     那么 A 就不配做父节 点，应该下去，
     下面那个更大的节点上来做父节点，这就是对 A 进行 下沉。
     */
    private void sink(int k) {
        // 如果沉到堆底，就沉不下去了
        while (left(k) <= N) {
            // 先假设左边节点较大,拿到左边
            int largest = left(k);
            //再拿到右边和左边的largest比，大的话赋值
            if (right(k) <= N && less(largest, right(k)))
                largest = right(k);
            //再拿结点 k 和俩孩子比。加入k最大，就不必下沉了
            if (less(largest, k)) break;
            // 否则，不符合最大堆的结构，下沉 k 结点
            exch(k, largest);
            k = largest;
        }
    }

    /* 交换数组的两个元素 */
    private void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
    // pq[i] 是否比 pq[j] 小?
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    // 父节点的索引
    int parent(int root) {
        return root / 2;
    }
    // 左孩子的索引
    int left(int root) {
        return root * 2;
    }
    // 右孩子的索引
    int right(int root) {
        return root * 2 + 1;
    }

}

