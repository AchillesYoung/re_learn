package DataStructure.LRU;

import java.util.HashMap;

public class LeastRecentlyUsed {

    // key ӳ�䵽 Node(key, val)
    HashMap<Integer, Node> map;
    //Node(k1, v1) <-> Node(k2, v2)...
    DoubleList cache;
    // �������
    private int cap;

    public LeastRecentlyUsed(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    int get(int key) {
        if (!map.containsKey(key)) return -1;
        int val = map.get(key).val;
        // ���� put �����Ѹ�������ǰ
        put(key, val);
        return val;
    }

    void put(int key, int val) {
        Node x = new Node(key, val);
        if (map.containsKey(key)) {
            // ɾ���ɵĽڵ㣬�µĲ嵽ͷ��
            cache.remove(map.get(key));
            cache.addFirst(x);
            // ���� map �ж�Ӧ������
            map.put(key, x);
        } else {
            if (cap == cache.size()) {
                // ɾ���������һ������
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            // ֱ����ӵ�ͷ��
            cache.addFirst(x);
            map.put(key, x);
        }
    }


    //���ҿ죬hash���ҿ죬����û��˳�������Ŀ�
    //����죬����
    //ɾ���죬����
    //��˳��
    //-->�����������hash����˫������͹�ϣ��Ľ�ϣ�

    /**
     * ΪʲôҪ��˫�������������в���?
     * ���⣬��Ȼ��ϣ���� �Ѿ����� key?
     * Ϊʲô�����л�Ҫ���ֵ���أ�ֻ��ֵ��������?
     * ��Ϊ��������ʱ��Ҫ�õ�keyȥɾ�����һ��Node�������õ�kȥɾ��hashMap
     */
    /**
     * �����hashmap��������ѯ
     * ����������ɾ������֤˳��
     */
    class Node {
        //˫����ڵ�
        public int key, val;
        public Node next, prev;

        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }

    /* ����˫����*/
    class DoubleList {
        // ������ͷ����ӽڵ� x��ʱ�� O(1)
        public void addFirst(Node x) {

        }

        // ɾ�������е� x �ڵ�(x һ������)
        // ������˫�����Ҹ�����Ŀ�� Node �ڵ㣬ʱ�� O(1)
        public void remove(Node x) {

        }

        // ɾ�����������һ���ڵ㣬�����ظýڵ㣬ʱ�� O(1)
        public Node removeLast() {
            return null;
        }

        // ��������?�ȣ�ʱ�� O(1)
        public int size() {
            return 0;
        }
    }
}
