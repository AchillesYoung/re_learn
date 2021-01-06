package DataStructure.LRU;

/**
 * 优先级队列这种数据结构有一个很有用的功能，你插入或者删除元素的时
 * 候，元素会自动排序，这底层的原理就是二叉堆的操作。
 * 数据结构的功能无非增删查该，优先级队列有两个主要 API，分别是
 * insert 插入一个元素和 delMax 删除最大元素(如果底层用最小堆，那么
 * 就是 delMin )。
 */
public class BinaryHeap {
    /**
     * 这里用到 Java 的泛型， Key 可以是任何一种可比较大 小的数据类型(int、char)
     */




    /**
     * 二叉堆其实就是一种特殊的二叉树(完全二叉树)，只不过存储在数
     * 组里。一般的链表二叉树，我们操作节点的指针，而在数组里，我们把数组
     * 索引作为指针:
     * 画个图你立即就能理解了，注意数组的第一个索引 0 空着不用
     */
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
