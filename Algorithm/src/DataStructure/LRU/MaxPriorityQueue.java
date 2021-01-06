package DataStructure.LRU;

public class MaxPriorityQueue
        <Key extends Comparable<Key>>{

    // �洢Ԫ�ص�����
    private Key[] pq;
    // ��ǰ Priority Queue �е�Ԫ�ظ���
    private int N = 0;

    public MaxPriorityQueue(int capacity) {
    // ���� 0 ���ã����Զ����һ���ռ�
        pq = (Key[]) new Comparable[capacity + 1];
    }
    //���ص�ǰ���
    public Key max(){
        return pq[1];
    }
    // ����Ԫ�� e���Ѷ������Ȼ���ϸ�����ȷλ��
    public void insert(Key e) {
        //���뵽���
        N++;
        pq[N] = e;
        // Ȼ�������ϸ�����ȷ��λ��
        swim(N);
    }

    // ɾ��max������max
    public Key delMax() {
        //ɾ�����ǰ� �Ѷ�Ԫ��A�Ͷѵ����Ԫ��b�Ի���ɾ��A��Ȼ����B�³�
        Key max = pq[1];
        //��������Ԫ�ػ������ɾ��֮
        exch(1, N);
        pq[N] = null;
        N--;
        // �� pq[1] �³�����ȷλ�� sink(1);
        return max;
    }

    /**
     * ���ĳ���ڵ� A �����ĸ��ڵ��
     * ��ô A ��Ӧ�����ӽڵ㣬Ӧ�ðѸ� �ڵ㻻������
     * �Լ�ȥ�����ڵ㣬����Ƕ� A ���ϸ���
     */
    private void swim(int k) {
        // ��������Ѷ����Ͳ������ϸ���
        while (k>1 && less(parent(k),k)){
            // ����� k ��Ԫ�ر��ϲ��
            // �� k ����ȥ
            exch(parent(k), k);
            k = parent(k);
        }
    }
    /**
     *
     1. ���ĳ���ڵ� A �������ӽڵ�(�е�һ��)С
     ��ô A �Ͳ��������� �㣬Ӧ����ȥ��
     �����Ǹ�����Ľڵ����������ڵ㣬����Ƕ� A ���� �³���
     */
    private void sink(int k) {
        // ��������ѵף��ͳ�����ȥ��
        while (left(k) <= N) {
            // �ȼ�����߽ڵ�ϴ�,�õ����
            int largest = left(k);
            //���õ��ұߺ���ߵ�largest�ȣ���Ļ���ֵ
            if (right(k) <= N && less(largest, right(k)))
                largest = right(k);
            //���ý�� k �������ӱȡ�����k��󣬾Ͳ����³���
            if (less(largest, k)) break;
            // ���򣬲��������ѵĽṹ���³� k ���
            exch(k, largest);
            k = largest;
        }
    }

    /* �������������Ԫ�� */
    private void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
    // pq[i] �Ƿ�� pq[j] С?
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    // ���ڵ������
    int parent(int root) {
        return root / 2;
    }
    // ���ӵ�����
    int left(int root) {
        return root * 2;
    }
    // �Һ��ӵ�����
    int right(int root) {
        return root * 2 + 1;
    }

}

