package Lead2Offer.sort;

import DataStructure.sort.Sort;

public class QuickSort {

    static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //����������
        quickSort(arr, 0, arr.length - 1);

    }

    static void quickSort(int[] arr, int left, int right) {
        // leftֻ��<right����Ȼ�ͽ���
        if (left >= right) {
            return;
        }
        //�ο����꣬
        int pivotIndex = partition(arr, left, right);
        quickSort(arr, left, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, right);

    }

    static int partition(int[] arr, int left, int right) {
        //,������ѡ��ͷnum���ο��ķ���
        int pivot = arr[left];

        //�ڿӷ�
        while (left != right) {
            while (arr[right] >= pivot && left < right) {
                right--;
            }
            //rightС��tmp,��left����
            arr[left] = arr[right];
            while (arr[left] <= pivot && left < right) {
                //cur<num, left++ cur++
                left++;
            }
            arr[right] = arr[left];

        }
        arr[left] = pivot;
        return left;
    }
}
