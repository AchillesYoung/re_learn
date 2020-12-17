package Lead2Offer.sort;

public class MergeSort {

    /**
     * O(N*logN)
     */
    public int[] mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        merge_sort_recursive(arr, 0, arr.length - 1);
        return arr;
    }

    /**
     * �ݹ������ O(logN)
     *
     * @return
     */
    public int[] merge_sort_recursive(int[] arr, int start, int end) {
        if (start == end) {
            return arr;
        }
        int mid = start + (start - end) >> 2;
        //������ĺ���
        merge_sort_recursive(arr, start, mid);
        //���ұ߱��ĺ���
        merge_sort_recursive(arr, mid + 1, end);
        //���������Һϲ�����������, O(N)
        mergeProcess(arr, start, end, mid);
        return arr;
    }

    public int[] mergeProcess(int[] arr, int start, int end, int mid) {
        //���������ռ����򣬲�Ȼ����һ����һ�߸��ǡ�
        int[] help = new int[end - start + 1];
        //������������+1��ס
        int pointLeft = start;
        int pointRight = mid + 1;
        int i = 0;
        while (pointLeft <= mid && pointRight <= end) {
            //ÿ��i��Ҫ��++����pointLeft��pointRight����һ��++
            help[i++] = arr[pointLeft] < arr[pointRight] ? arr[pointLeft++] : arr[pointRight++];
        }
        while (pointLeft <= mid) {
            help[i] = arr[pointLeft];
        }
        while (pointRight <= end) {
            help[i] = arr[pointRight];
        }
        //������Ҫcopy��֮ǰ������
        for (i = 0; i < help.length; i++) {
            arr[start + i] = help[i];
        }
        return help;

    }
}
