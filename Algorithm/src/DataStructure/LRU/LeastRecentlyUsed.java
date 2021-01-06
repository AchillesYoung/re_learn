package DataStructure.LRU;

import java.util.HashMap;

public class LeastRecentlyUsed {

    // key 映射到 Node(key, val)
    HashMap<Integer, Node> map;
    //Node(k1, v1) <-> Node(k2, v2)...
    DoubleList cache;
    // 最大容量
    private int cap;

    public LeastRecentlyUsed(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    int get(int key) {
        if (!map.containsKey(key)) return -1;
        int val = map.get(key).val;
        // 利用 put 方法把该数据提前
        put(key, val);
        return val;
    }

    void put(int key, int val) {
        Node x = new Node(key, val);
        if (map.containsKey(key)) {
            // 删除旧的节点，新的插到头部
            cache.remove(map.get(key));
            cache.addFirst(x);
            // 更新 map 中对应的数据
            map.put(key, x);
        } else {
            if (cap == cache.size()) {
                // 删除链表最后一个数据
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            // 直接添加到头部
            cache.addFirst(x);
            map.put(key, x);
        }
    }


    //查找快，hash查找快，但是没有顺序。数组查的快
    //插入快，链表
    //删除快，链表
    //有顺序
    //-->数组链表或者hash链表（双向链表和哈希表的结合）

    /**
     * 为什么要是双向链表，单链表行不行?
     * 另外，既然哈希表中 已经存了 key?
     * 为什么链表中还要存键值对呢，只存值不就行了?
     * 因为缓存满的时候，要用到key去删除最后一个Node，并且拿到k去删除hashMap
     */
    /**
     * 这里的hashmap是用来查询
     * 链表是用来删除，保证顺序
     */
    class Node {
        //双链表节点
        public int key, val;
        public Node next, prev;

        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }

    /* 构造双链表*/
    class DoubleList {
        // 在链表头部添加节点 x，时间 O(1)
        public void addFirst(Node x) {

        }

        // 删除链表中的 x 节点(x 一定存在)
        // 由于是双链表且给的是目标 Node 节点，时间 O(1)
        public void remove(Node x) {

        }

        // 删除链表中最后一个节点，并返回该节点，时间 O(1)
        public Node removeLast() {
            return null;
        }

        // 返回链表?度，时间 O(1)
        public int size() {
            return 0;
        }
    }
}
