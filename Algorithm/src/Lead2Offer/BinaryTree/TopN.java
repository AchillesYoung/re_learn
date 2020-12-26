package Lead2Offer.BinaryTree;

import java.util.Arrays;

import static DataStructure.sort.Sort.*;

public class TopN {
    public static void heapSort(int[] arr , int k) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //step1����󶥶�
        for (int i = 0; i < arr.length; i++) {
            //�����һ������
            heapInsert(arr, i);
        }
        int right = arr.length - 1;
        //step1��λ�ã��ٴ�heapify
        swap(arr, 0, right);
        for(int i = 1; i < k ; ++i ) {
            heapify(arr, 0, right);
            swap(arr, 0, --right);
        }
    }

    private static void heapify(int[] arr, int index, int size) {

        int left = index * 2 + 1;
        while (left < size){
            int largest = left + 1 < size && arr[left] < arr[left + 1] ? left+1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if(largest == index){
                //��Ϊֻ����root�ڵ㣬���Բ���Ҫ���¼����ж�
                break;
            }
            swap(arr, largest, index);

            index = largest;

            left = index * 2 +1;
        }

    }

    private static void heapInsert(int[] arr, int index) {
        /**
         * ���׽ڵ�Ҫ���ӽڵ�С������
         */
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index-1)/2);
            index  = (index - 1)/2;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void main(String[] args) {

//        int[] arr = generateRandomArray(10, 20);
        int[] arr1 = {12,10,1,3,9,13,15,-3,-2,6,3,8,2,1,4,12};
        printArray(arr1);
        heapSort(arr1 , 4);
        printArray(arr1);

    }

}
