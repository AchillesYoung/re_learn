package Lead2Offer.sort;

public class HeapSort {

    /**
     * �����󶥶ѣ�Ȼ����������һλ��λ��
     */
    public int[] heap_sort(int[] unsorted_arry) {
        int size = unsorted_arry.length;
        if (unsorted_arry == null || size < 2) {
            return unsorted_arry;
        }

        //step1���Ȱ�ԭʼ���鹹����һ�δ󶥶ѣ������ٽ�������
        //ѭ���������飬��Ԫ�����β��빹��Ĵ󶥶ѣ����¹���
        for (int i = 0; i < size; ++i) {
            heap_insert(unsorted_arry, i);
        }
        //step2�����������ͷ�ڵ������swapһ�£������С�ٴι�������β���insert�ˣ���Ϊֻ�Ƕ�ͷ����
        swap(unsorted_arry, 0, --size);
        while (size > 0) {
            //���ﴫ����size������end������Ҫsize-1
            heapify(unsorted_arry, 0, size);
            //�ȸ�ֵ��--
            swap(unsorted_arry, 0, --size);
        }
        return unsorted_arry;
    }

    /**
     * �������ӽڵ�����
     * index/2 = parent
     * index * 2 + 1 = leftChild, index * 2 + 2 = rightChild
     * 0-1-2-3-4-5-6
     * //      0
     * //  1       2
     * //3   4  5     6
     */
    private void heap_insert(int[] arr, int index) {
        //��һ��"���鹹���ѹ���"��������ȫ���ڼ��ӽڵ㣬��������->���Ķ�Ӧ���������Ժ��Ը�Ҷ�ڵ�����ӽڵ�
        //��������ֻ��͸��ڵ�Ƚϣ�ѭ������
        while (arr[index] >= arr[(index - 1) >> 1]) {
            swap(arr, index, (index - 1) >> 1);
            //���������Ƚ���������ʱ��ø��ڵ��ү�ڵ�Ƚ�
            index = (index - 1) >> 1;
        }
    }

    /**
     * heapify�ع�����Ӧ�������µݹ�ģ�(��ʱ��Ԫ���Ѿ����µģ����������µ����µݹ�
     * ÿ�����µݹ飬��Ҫ�Ա�С�����������ڵ㣬
     * �ȼ�����ڵ��Ƿ񳬳����ڵ��������鳤�ȣ�left<size��-->���ﳤ��sizeҪ���������ֿ�
     * ��������������鳤��size��
     * ������ڵ㣨�����ڵ����index * 2 + 1��
     */
    public void heapify(int[] arr, int index, int size) {
        /**
         * heapify�ع�����Ӧ�������µݹ�ģ�(��ʱ��Ԫ���Ѿ����µģ����������µ����µݹ�
         * ÿ�����µݹ飬��Ҫ�Ա�С�����������ڵ㣬
         * �ȼ�����ڵ��Ƿ񳬳����ڵ��������鳤�ȣ�left<size��-->���ﳤ��sizeҪ���������ֿ�
         * ��������������鳤��size��
         * ������ڵ㣨�����ڵ����index * 2 + 1��
         */
        int left = index * 2 + 1;
        //�����ж��ӽڵ����� left <= size -1
        while (left <= size - 1) {
            //���αȽ��õ������ڵ����ֵ����
            int largest = left + 1 <= size - 1 && arr[left + 1] >arr[left] ? left+1 : left;
            //�ȶԱȶ����ӽڵ㣬�õ����Ľڵ����������ȥ�͸��ڵ�index�Ƚϣ������õ�largest
            //�����õ���������������Ԫ������
            largest = arr[largest] > arr[index] ? largest : index;
            //������ľ���index������ѭ������Ȼ�����������µݹ�
            if (largest == index) {
                break;
            }
            //�����ӽڵ���ˣ�Ҫ�������ڵ㣬���´���
            swap(arr, largest, index);
            //�������£�stack�ݹ��
            // ����û�����������ĸ�������Ϊ�ĸ��ڵ�����˻�λ�ͻ����ĸ��ڵ�������±�����ֱ��Ҷ�ڵ�
            index = largest;
            //���¸���leftȥ�ж��Ƿ��´λ�Խ��
            left = index * 2 + 1;
        }

    }

    private void swap(int[] arr, int i, int j) {
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }

}
