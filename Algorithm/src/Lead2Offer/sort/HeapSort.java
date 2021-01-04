package Lead2Offer.sort;

import java.util.Arrays;

import static DataStructure.sort.Sort.*;

public class HeapSort {
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //�Ȱ������һ�ζѻ�
        for (int i = 0; i < arr.length; ++i) {
            heapSort(arr, i);
        }

        //�����û��Ѷ��ڵ㣬Ȼ�����¹���
        int size = arr.length;
        swap(arr, 0, --size);
        while (size > 0) {
            heapify(arr, size);
            swap(arr, 0, --size);
        }
    }

    private static void heapify(int[] arr, int size) {

        int index = 0;
        int left = index * 2 + 1;
        while (left < size) {

            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;

            largest = arr[largest] > arr[index] ? largest : index;

            if (largest == index) {
                break;
            }
            //�����ӽڵ���ˣ�Ҫ�������ڵ㣬���´���
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;

        }

    }

    private static void heapSort(int[] arr, int index) {
        //��һ��"���鹹���ѹ���"��������ȫ���ڼ��ӽڵ㣬��������->���Ķ�Ӧ������
        // ������Ը�Ҷ�ڵ�����������ӽڵ㣬û�¼�һ���ӽڵ㣬��ѭ���͸����ڵ�Ƚϴ�С��
        //��������ֻ��͸��ڵ�Ƚϣ�ѭ������

        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private static void swap(int[] arr, int j, int i) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            heapSort(arr1);
            Arrays.sort(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucked!");
        int[] arr = new int[]{5, 8, 2, 3, 0, 7, 4, 6};
        printArray(arr);

        heapSort(arr);
        System.out.println();
        printArray(arr);
        Arrays.sort(arr);
        printArray(arr);

        System.out.println();

    }
}
